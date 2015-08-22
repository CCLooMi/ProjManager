/**
 * Created by chenxianjun on 15/7/26.
 */
String.prototype.format= function () {
    var result=this;
    if(arguments.length){
        for(var i in arguments){
            var v=arguments[i];
            result=result.replace('\?',v);
        }
    }
    return result;
}
$(document).ready(function () {
    $.ajax({
    	async:true,
        url:"allRAUvisData",
        method:"POST",
        contentType:"application/json",
        dataType:"json",
        error:function(e){
            alert(JSON.stringify(e));
        },
        success:function(data){
            draw(data);
        }
    });
    var clipboard={};
    var userObj={
    		"id":{"label":"ID","type":"text","hidden":true},
    		"username":{"label":"用户名","type":"text"},
    		"nickname":{"label":"昵称","type":"text","for":"label"},
    		"password":{"label":"密码","type":"password"}
        };
    var roleObj={
    		"id":{"label":"ID","type":"text","hidden":true},
    		"name":{"label":"名称","type":"text","for":"label"}
        };
    var authorityObj={
    		"id":{"label":"ID","type":"text","hidden":true},
    		"name":{"label":"名称","type":"text","for":"label"},
    		"url":{"label":"地址","type":"text"},
    		"idParent":{"label":"父ID","type":"text","hidden":true}
        };
    function draw(data){
        //用来检测重复连接
        var edgesSet=[];
        for(var eg in data.edges){
            edgesSet.push(data.edges[eg].from+'#'+data.edges[eg].to);
        };
        var addSet={};
        var delSet={};
        var inADD_DEL_set= function (s) {
            return addSet[s]||delSet[s];
        };
        var menu=[
            {icon:'glyphicon-save-file',text:"保存"},
            {icon:'glyphicon-refresh',text:"刷新"},
            {icon:'glyphicon-pushpin',text:'固定'},
            {menu_item_src:clipboardMenu},
            {menu_item_src:operateMenu}
        ];

        context.init({
            targetClickEvent: targetClickEvent
        });
        var keyEvents={};
        var nodes=new vis.DataSet(data.nodes);
        var edges=new vis.DataSet(data.edges);
        var data={
            "nodes":nodes,
            "edges":edges
        };
        var imgDIR="res/img/";
        var container=document.getElementById("network");
        var options={
            manipulation:{
                enabled:false,
                addEdge: function (data, callback){
                    var dataRevert={'from':data.to,'to':data.from};
                    var fromNode=nodes.get(data.from);
                    var toNode=nodes.get(data.to);
                    var newElement=fromNode.id+'#'+toNode.id;
                    var newElement_revert=toNode.id+'#'+fromNode.id;
                    if(edgesSet.indexOf(newElement)!=-1){
                        if(delSet[newElement]){//已删除直接恢复
                            callback(data);
                            delete  delSet[newElement];
                        }
                    }else if(!addSet[newElement]&&!addSet[newElement_revert]){
                        if(fromNode.group=='authority'&&toNode.group=='role'){
                            //roleAuthority/add
                            addSet[newElement]='roleauthority';
                            callback(data);
                        }else if(fromNode.group=='user'&&toNode.group=='role'){
                            //roleUser/add
                            addSet[newElement]='roleuser';
                            callback(data);
                            //只有菜单会有环路出现，故from不能等于to,已有连接则不能再反向连接
                        }else if(fromNode.group=='authority'&&toNode.group=='authority'&&fromNode.id!=toNode.id){
                            //authority/update
                            if(edgesSet.indexOf(newElement_revert)!=-1){
                                if(delSet[newElement_revert]){
                                    callback(data);
                                    delete  delSet[newElement_revert];
                                }
                            }else{
                                addSet[newElement]='authority';
                                callback(data);
                            }
                        }else if(fromNode.group=='role'&&toNode.group=='authority'){//反向
                            if(edgesSet.indexOf(newElement_revert)!=-1){
                                if(delSet[newElement_revert]){
                                    callback(data);
                                    delete  delSet[newElement_revert];
                                }
                            }else{
                               if(!addSet[newElement_revert]){
                                   addSet[newElement_revert]='roleauthority';
                                   callback(dataRevert);
                               }
                            }

                        }else if(fromNode.group=='role'&&toNode.group=='user'){//反向
                            if(edgesSet.indexOf(newElement_revert)!=-1){
                                if(delSet[newElement_revert]){
                                    callback(data);
                                    delete  delSet[newElement_revert];
                                }
                            }else{
                                if(!addSet[newElement_revert]){
                                    addSet[newElement_revert]='roleuser';
                                    callback(dataRevert);
                                }
                            }
                        }
                    }
                    callback();
                },
                editEdge: function (data, callback) {
                    var oldEdge=edges.get(data.id);
                    var oldFromNode=nodes.get(oldEdge.from);
                    var oldToNode=nodes.get(oldEdge.to);
                    var oldElement=oldFromNode.id+'#'+oldToNode.id;

                    var newEdge=data;
                    var newEdge_revert= {'from':data.to,'to':data.from};
                    var newFromNode=nodes.get(newEdge.from);
                    var newToNode=nodes.get(newEdge.to);
                    var newElement=newFromNode.id+'#'+newToNode.id;
                    var newElement_revert=newToNode.id+'#'+newFromNode.id;

                    if(edgesSet.indexOf(newElement)!=-1){//该newEdge必为已存在的edge，只能存在于delSet中
                        info('该newEdge必为已存在的edge，只能存在于delSet或updSet中');
                        if(delSet[newElement]){//如果已删除则恢复即可
                            newEdge.id=delSet[newElement];
                            callback(newEdge);
                            delete  delSet[newElement];
                            if(edgesSet.indexOf(oldElement)!=-1){//如果oldEdge已存在，需要添加到delSet中
                                delSet[oldElement]=oldEdge.id;
                            }else{//若果oldEdge为新增加的，则该oldEdge必在addSet中，直接从addSet删除即可
                                delete addSet[oldElement];
                            }
                        }
                    }else{//该newEdge为新增的edge,只能存在addSet中
                        info('该newEdge为新增的edge,只能存在addSet中');
                        if(addSet[newElement]){//已经添加该edge
                            callback();
                        }else{//还没有添加
                            if(newFromNode.group=='authority'&&newToNode.group=='role'){
                                addSet[newElement]='roleAuthority';
                                callback(newEdge);
                                if(edgesSet.indexOf(oldElement)!=-1){//如果oldEdge已存在，需要添加到delSet中
                                    delSet[oldElement]=oldEdge.id;
                                }else{//若果oldEdge为新增加的，则该oldEdge必在addSet中，直接从addSet删除即可
                                    delete addSet[oldElement];
                                }
                            }else if(newFromNode.group=='user'&&newToNode.group=='role'){
                                addSet[newElement]='roleUser';
                                callback(newEdge);
                                if(edgesSet.indexOf(oldElement)!=-1){//如果oldEdge已存在，需要添加到delSet中
                                    delSet[oldElement]=oldEdge.id;
                                }else{//若果oldEdge为新增加的，则该oldEdge必在addSet中，直接从addSet删除即可
                                    delete addSet[oldElement];
                                }
                            }else if(newFromNode.group=='authority'&&newToNode.group=='authority'&&newFromNode.id!=newToNode.id){
                                if(edgesSet.indexOf(newElement_revert)!=-1){
                                    if(delSet[newElement_revert]){
                                        addSet[newElement]='authority';
                                        callback(newEdge);
                                        if(edgesSet.indexOf(oldElement)!=-1){//如果oldEdge已存在，需要添加到delSet中
                                            delSet[oldElement]=oldEdge.id;
                                        }else{//若果oldEdge为新增加的，则该oldEdge必在addSet中，直接从addSet删除即可
                                            delete addSet[oldElement];
                                        }
                                    }
                                }else{
                                    addSet[newElement]='authority';
                                    callback(newEdge);
                                    if(edgesSet.indexOf(oldElement)!=-1){//如果oldEdge已存在，需要添加到delSet中
                                        delSet[oldElement]=oldEdge.id;
                                    }else{//若果oldEdge为新增加的，则该oldEdge必在addSet中，直接从addSet删除即可
                                        delete addSet[oldElement];
                                    }
                                }
                            }else if(newFromNode.group=='role'&&newToNode.group=='authority'){//反向
                                if(edgesSet.indexOf(newElement_revert)!=-1){
                                    if(delSet[newElement_revert]){
                                        newEdge_revert.id=delSet[newElement_revert];
                                        callback(newEdge_revert);
                                        delete delSet[newElement_revert];
                                        if(edgesSet.indexOf(oldElement)!=-1){//如果oldEdge已存在，需要添加到delSet中
                                            delSet[oldElement]=oldEdge.id;
                                        }else{//若果oldEdge为新增加的，则该oldEdge必在addSet中，直接从addSet删除即可
                                            delete addSet[oldElement];
                                        }
                                    }
                                }else{
                                    addSet[newElement_revert]='roleauthority';
                                    callback(newEdge_revert);
                                }
                            }else if(newFromNode.group=='role'&&newToNode.group=='user'){//反向
                                if(edgesSet.indexOf(newElement_revert)!=-1){
                                    if(delSet[newElement_revert]){
                                        newEdge_revert.id=delSet[newElement_revert];
                                        callback(newEdge_revert);
                                        delete delSet[newElement_revert];
                                        if(edgesSet.indexOf(oldElement)!=-1){//如果oldEdge已存在，需要添加到delSet中
                                            delSet[oldElement]=oldEdge.id;
                                        }else{//若果oldEdge为新增加的，则该oldEdge必在addSet中，直接从addSet删除即可
                                            delete addSet[oldElement];
                                        }
                                    }
                                }else{
                                    addSet[newElement_revert]='roleuser';
                                    callback(newEdge_revert);
                                }
                            }
                        }
                    };
                    callback();
                }
            },
            nodes: {
                shadow:true
            },
            edges: {
                shadow:true,
                color: "green",
                arrows:'to'
            },
            groups: {
                user: {
                    shape: 'circularImage',
                    image: imgDIR+'head.jpg',
                    color: 'white'
                },
                role: {
                    shape: 'image',
                    image: imgDIR+'eye.svg'
                },
                authority: {
                    shape: 'image',
                    image: imgDIR+'leaf-sm.svg'
                }
            },
            layout:{//保证每次生成的视图都是一样的
                //randomSeed:2
            },
            interaction: {
                tooltipDelay: 200,
                hideEdgesOnDrag: true
            }
        };
        var network=new vis.Network(container,data,options);
        //监听右击事件
        network.on("oncontext", function (params) {
            params.event.preventDefault();
            //纪录鼠标右击坐标，以在粘贴中需要用到
            clipboard.pointer=params.pointer;
            var dom=params.pointer.DOM;
            var nodeid=network.getNodeAt(params.pointer.DOM);
            if(nodeid){
                network.selectNodes([nodeid],true);
            }else{
                var edgeid=network.getEdgeAt(params.pointer.DOM);
                if(edgeid)network.selectEdges([edgeid]);
            }
            context.show(params,menu);
        });
        //监听双击事件
        network.on("doubleClick", function (params) {
            var ns=params.nodes.length;
            var es=params.edges.length;
            var canv=params.pointer.canvas;
            if(ns){//双击的是node
                var nd=nodes.get(params.nodes[0]);
                if(nd.group==='user'){
                    showDialog("编辑用户",userObj,nd, function (d) {
                        nd=updateToNode(d,nd,userObj);
                        nodes.update(nd);
                    });
                }else if(nd.group==='role'){
                    showDialog("编辑角色",roleObj,nd, function (d) {
                        nd=updateToNode(d,nd,roleObj);
                        nodes.update(nd);
                    });
                }else if(nd.group==='authority'){
                    showDialog("编辑菜单",authorityObj,nd, function (d) {
                        nd=updateToNode(d,nd,authorityObj);
                        nodes.update(nd);
                    });
                };
            }else if(es){//双击的是edges
                //network.enableEditMode();
                network.editEdgeMode();
            }else{//双击的是空白处
                //nodes.add({label:"NEW",x:canv.x,y:canv.y});
                var obj={};
                obj.ADD=addSet;
                obj.DEL=delSet;
                info(obj);
            }
        });
        network.on("dragEnd", function (params) {
            if(keyEvents.altKey)network.addEdgeMode();//判断Alt键是否hold，如果是则继续addEdgeMode
            //network.startSimulation();
        });
        //监听键盘事件
        $(document).keydown(function (e) {
            if(e.keyCode==46){//Delete
                network.deleteSelected();
            }else if(e.keyCode==13){//Enter
                network.getSelectedNodes();
                network.getSelectedEdges();
            }else if(e.keyCode==18){//Alt
            	if(!keyEvents.altKey){
                    keyEvents.altKey= e.altKey;
                    network.addEdgeMode();
            	}
            }
            info(e.keyCode);
        });
        $(document).keyup(function (e) {
            if(e.keyCode==18){//Alt
                keyEvents.altKey= e.altKey;
                network.disableEditMode();
            }
        })
        //处理菜单事件
        function targetClickEvent(e){
            var target=$(e.target);
            e.preventDefault();
            var ok='<span style="left:65px;top:2px;color:green" class="glyphicon glyphicon-ok"></span>';
            //固定
            if(is('pushpin')){
                options.nodes.fixed=options.nodes.fixed?false:true;
                network.setOptions(options);
                if(options.nodes.fixed)target.html(target.html()+ok);
                else target.html(target.html().replace(ok,''));
                //剪切
            }else if(is('scissors')){//cute
                clipboard.copy=undefined;
                clipboard.cute=network.getSelection();
                clipboard.cute.nodes=nodes.get(clipboard.cute.nodes);
                clipboard.cute.edges=edges.get(clipboard.cute.edges);
                info(clipboard);
                //复制
            }else if(is('duplicate')){
                clipboard.cute=undefined;
                clipboard.copy=network.getSelection();
                clipboard.copy.nodes=nodes.get(clipboard.copy.nodes);
                clipboard.copy.edges=edges.get(clipboard.copy.edges);
                info(clipboard);
                //粘贴
            }else if(is('paste')){
                if(clipboard.cute){
                    //删除需要剪切的node
                    network.deleteSelected();
                    for(var i in clipboard.cute.nodes){
                        clipboard.cute.nodes[i].x=clipboard.pointer.canvas.x;
                        clipboard.cute.nodes[i].y=clipboard.pointer.canvas.y;
                    }
                    if(clipboard.cute.nodes.length)nodes.add(clipboard.cute.nodes);
                    //if(clipboard.cute.edges.length)nodes.add(clipboard.cute.edges);
                    clipboard.cute=undefined;//只能剪切一次
                }else if(clipboard.copy){
                    for(var i in clipboard.copy.nodes){
                        clipboard.copy.nodes[i]=copyObject(clipboard.copy.nodes[i]);
                        clipboard.copy.nodes[i].id=undefined;
                        clipboard.copy.nodes[i].x=clipboard.pointer.canvas.x;
                        clipboard.copy.nodes[i].y=clipboard.pointer.canvas.y;
                    }
                    if(clipboard.copy.nodes.length)nodes.add(clipboard.copy.nodes);
                    //if(clipboard.copy.edges.length)nodes.add(clipboard.copy.edges);
                }
                //刷新
            }else if(is('refresh')){
                network.disableEditMode();
                network.redraw();
                //编辑
            }else if(is('edit')){
                var selection=network.getSelection();
                var ns=selection.nodes.length;
                var es=selection.edges.length;
                if(ns){//node
                    var nd=nodes.get(selection.nodes[0]);
                    if(nd.group==='user'){
                        showDialog("编辑用户",userObj,nd, function (d) {
                            nd=updateToNode(d,nd,userObj);
                            nodes.update(nd);
                        });
                    }else if(nd.group==='role'){
                        showDialog("编辑角色",roleObj,nd, function (d) {
                            nd=updateToNode(d,nd,roleObj);
                            nodes.update(nd);
                        });
                    }else if(nd.group==='authority'){
                        showDialog("编辑菜单",authorityObj,nd, function (d) {
                            nd=updateToNode(d,nd,authorityObj);
                            nodes.update(nd);
                        });
                    }
                }else if(es){//edges
                    network.editEdgeMode();
                }
                //添加用户
            }else if(is('user')){
                showDialog('添加用户',userObj,null, function (d) {
                    sendData("user/add",d, function (data) {
                        if(data.code==0){
                            var nd=toVisNode(d,userObj);
                            nd.group='user';
                            nd.id=data.info;
                            nodes.add(nd);
                        }else if(data.code==1){
                            alert(data.info);
                        }
                    });
                });
                //添加角色
            }else if(is('eye-open')){
                showDialog('添加角色',roleObj,null, function (d) {
                    sendData("role/add",d, function (data) {
                        if(data.code==0){
                            var nd=toVisNode(d,roleObj);
                            nd.group='role';
                            nd.id=data.info;
                            nodes.add(nd);
                        }else if(data.code==1){
                            alert(data.info);
                        }
                    });
                });
                //添加关联
            }else if(is('link')){
                network.addEdgeMode();
                //添加菜单
            }else if(is('grain')){
                var selection=network.getSelection();
                var ns=selection.nodes.length;
                var selectNode=nodes.get(selection.nodes[0]);
                showDialog('添加菜单',authorityObj,null, function (d) {
                    if(ns&&selectNode.group==='authority'){//添加子菜单
                        d.idParent=selectNode.id;
                        sendData("authority/add",d, function (data) {
                           if(data.code==0){
                               var nd=toVisNode(d,authorityObj);
                               nd.group='authority';
                               nd.id= data.info;
                               nodes.add(nd);
                               edges.add({from:nd.id,to:selectNode.id});
                           }else if(data.code==1){
                               alert(data.info);
                           }
                        });
                    }else{//添加菜单
                        sendData("authority/add",d, function (data) {
                            if(data.code==0){
                                var nd=toVisNode(d,authorityObj);
                                nd.group='authority';
                                nd.id= data.info;
                                nodes.add(nd);
                            }else if(data.code==1){
                                alert(data.info);
                            }
                        });
                    }
                });
                //删除
            }else if(is('trash')){
                var selection=network.getSelection();
                var ns=selection.nodes.length;
                var es=selection.edges.length;
                if(ns){//node
                    var nd=nodes.get(selection.nodes[0]);
                    if(nd.group==='user'){
                        sendData("user/delete","id="+nd.id, function (data) {
                            if(data.code==0){
                                network.deleteSelected();
                            }else if(data.code==1){
                                alert(data.info);
                            }
                        });
                    }else if(nd.group==='role'){
                        sendData("role/delete","id="+nd.id, function (data) {
                           if(data.code==0){
                               network.deleteSelected();
                           }else if(data.code==1){
                               alert(data.info);
                           }
                        });
                    }else if(nd.group==='authority'){
                        sendData("authority/delete","id="+nd.id, function (data) {
                            if(data.code==0){
                                network.deleteSelected();
                            }else if(data.code==1){
                                alert(data.info);
                            }
                        });
                    }
                }else if(es){//edges
                    var eg=edges.get(selection.edges[0]);
                    info(eg);
                }
                //查看
            }else if(is('blackboard')){

            }
            //内部方法，用来判断是哪个span触发click事件
            function is(c){
                return target.find('span.glyphicon-'+c).length;
            }
        }//targetClickEvent - end

        //动态生成菜单
        function clipboardMenu(){
            var m=[];
            m.push({divider: true});
            if(clipboard.cute||clipboard.copy){
                m.push({icon:'glyphicon-paste',text:'粘贴'});
            }
            if(network.getSelection().nodes.length){
                m.push({icon:'glyphicon-scissors',text:'剪切'});
                m.push({icon:'glyphicon-duplicate',text:'复制'});
            }
            //如果没有菜单则清空数组
            if(m.length==1){
                m=[];
            }
            return m;
        }
        function operateMenu(){
            var m=[];
            m.push({divider: true});
            m.push({icon:'glyphicon-plus',text:'添加',subMenu:[
                {icon:'glyphicon-eye-open',text:'角色'},
                {icon:'glyphicon-user',text:'用户'},
                {icon:'glyphicon-link',text:'关联'},
                {icon:'glyphicon-grain',text:'菜单'}
            ]});
            if(network.getSelection().nodes.length||network.getSelection().edges.length){
                m.push({icon:'glyphicon-edit',text:"编辑"});
                m.push({icon:'glyphicon-trash',text:"删除"});
            }
            if(network.getSelection().nodes.length){
                m.push({icon:'glyphicon-blackboard',text:'查看'});
                //m[1].subMenu.push({icon:'glyphicon-leaf',text:'子菜单'});
            }
            return m;
        }
        window.clipboardMenu=clipboardMenu;
        window.operateMenu=operateMenu;
    };//draw-end
    function getUUID(){
        return 'UUID'+new Date().getTime();
    };
    function sendData(url,d,callback){
        if(d){
            var td,cType;
            if(typeof d == 'string'){
                td=d;
            }else if(typeof d == 'object'){
                td=JSON.stringify(d);
                cType="application/json";
            }
            $.ajax({
                async:true,//异步请求
                url:url,
                method:"POST",
                contentType:cType,
                dataType:"json",
                data:td,
                error:function(e){
                    alert(JSON.stringify(e));
                },
                success:function(data){
                    callback(data);
                }
            });
        };
    };
    //显示对话框
    function showDialog(title,obj,data,ok,cancel){
        return dialog({
            title:title,
            content:getObjHtml(obj,data||{}),
            okValue:'确定',
            ok:function(){
                ok=ok||function(target){};
                var d={},target=$("[i-id='ok']");
                target.closest("tr").prev("tr").find("form input").each(function () {
                    var $this = $(this);
                    d[$this.attr("id")]=$this.val()==''?null:$this.val();
                });
                ok(d);
            },
            cancelValue:'取消',
            cancel:function () {
                cancel=cancel||function(target){};
                cancel($("[i-id='cancel']"));
            }
        }).width(450).show();
    };
    //根据参考对象和obj更新Node对象
    function updateToNode(obj,node,referObj){
        for(var p in obj){
            node[referObj[p]['for']||p]=obj[p];
        }
        return node;
    }
    //根据参考对象和obj生成node对象
    function toVisNode(obj,referObj){
        var nd={};
        for(var p in obj){
            nd[referObj[p]['for']||p]=obj[p];
        }
        return nd;
    }
    //用户生成添加的表单
    function getObjHtml(obj,data){
        var s='<form class="form-horizontal">?</form>'
        var tp='<div class="form-group ?"><label for="?" class="col-sm-2 control-label">?</label><div class="col-sm-10"><input type="?" class="form-control" id="?" placeholder="?" value="?"></div></div>';
//        var type=['password','email','text'];
        var html='';
        for(var p in obj){
            var t=obj[p];
            html+=tp.format((t.hidden?'hidden':''),p,t.label, t.type,p, t.label,data[p]||data[t['for']]||'');
        }
        html= s.format(html);
        return html;
    };
    //复制对象
    function copyObject(obj){
        var copyObj={};
        for(var k in obj){
            copyObj[k]=obj[k];
        }
        return copyObj;
    };
    //显示信息
    function info(obj){
        if(typeof  obj=='object'){
            $("#INFO").html(JSON.stringify(obj,null,4));
        }else if(typeof  obj=='string'){
            $("#INFO").html(obj);
        }
    };
});