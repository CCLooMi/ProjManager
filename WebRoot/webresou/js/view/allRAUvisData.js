/**
 * Created by chenxianjun on 15/7/26.
 */
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
    function draw(data){
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
            manipulation:false,
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
                    image: imgDIR+'leaf.svg',
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
        network.on("oncontext", function (params) {
            params.event.preventDefault();
            var dom=params.pointer.DOM;
            $("button").html(JSON.stringify(dom));

        });
        network.on("doubleClick", function (params) {
            var ns=params.nodes.length;
            var es=params.edges.length;
            var canv=params.pointer.canvas;
            if(ns){//双击的是node
                alert(JSON.stringify(nodes._data[params.nodes[0]]));
                if(es){//如果有边
                    for(var edg in params.edges){
                        alert(JSON.stringify(edges._data[params.edges[edg]]));
                    }
                }
            }else if(es){//双击的是edges
                //network.enableEditMode();
                network.editEdgeMode();
            }else{//双击的是空白处
                nodes.add({label:"NEW",x:canv.x,y:canv.y});
            }
        });
        network.on("dragEnd", function (params) {
            if(keyEvents.altKey)network.addEdgeMode();//判断Alt键是否hold，如果是则继续addEdgeMode
        });
        $(document).keydown(function (e) {
            if(e.keyCode==46){//Delete
                network.deleteSelected();
            }else if(e.keyCode==13){//Enter
                network.getSelectedNodes();
                network.getSelectedEdges();
            }else if(e.keyCode==18){//Alt
                keyEvents.altKey= e.altKey;
                network.addEdgeMode();
            }
            $("button").html(e.keyCode);
        });
        $(document).keyup(function (e) {
            if(e.keyCode==18){//Alt
                keyEvents.altKey= e.altKey;
                network.disableEditMode();
            }
        })
        $("button").click(function(e){
            var target=$(e.target);
            var selectNodeid=network.getSelectedNodes();
            if(selectNodeid!='')alert(selectNodeid);
        });
    };
});