// Wrapping in nv.addGraph allows for '0 timeout render', stores rendered charts in nv.graphs, and may do more in the future... it's NOT required
    var chart;
    var colors = ["#ff7f0e","#2ca02c","#2222ff","#667711","#EF9CFB"];
	//var data = [{values: [{x:50,y:0.026843000203371048},{x:100,y:0.002764000091701746},{x:150,y:0.0035520000383257866},{x:200,y:0.002368000103160739}],key: "Bubble Sort",color: colors[0]},
	//			{values: [{x:50,y:0.0027630000840872526},{x:100,y:0.0011840000515803695},{x:150,y:0.0015790000325068831},{x:200,y:0.001973999897018075}],key: "Selection Sort",color: colors[1]}];
	
	var data = [{values:[{x:10,y:12.110857009887695},{x:100,y:20.038448333740234},{x:500,y:29.0598087310791},{x:1000,y:44.7044563293457},{x:2000,y:42.14536666870117},{x:4000,y:116.75308227539062},{x:6000,y:259.1345520019531},{x:10000,y:697.1582641601562},{x:15000,y:1530.6314697265625},{x:20000,y:2000.0}],key:"BubbleSort",color:colors[0]},{values:[{x:10,y:0.9677789807319641},{x:100,y:5.5066118240356445},{x:500,y:28.943883895874023},{x:1000,y:17.151464462280273},{x:2000,y:28.300819396972656},{x:4000,y:172.4431610107422},{x:6000,y:322.0046691894531},{x:10000,y:483.7424621582031},{x:15000,y:1016.69189453125},{x:20000,y:1744.6622314453125}],key:"SelectionSort",color:colors[1]},{values:[{x:10,y:0.8946139812469482},{x:100,y:4.230943202972412},{x:500,y:16.914953231811523},{x:1000,y:22.23649787902832},{x:2000,y:48.96685028076172},{x:4000,y:113.23441314697266},{x:6000,y:245.5574951171875},{x:10000,y:759.7164306640625},{x:15000,y:1500.43017578125},{x:20000,y:2000.0}],key:"InsertionSort",color:colors[2]}];;
	
	nv.addGraph(function() {
        chart = nv.models.lineChart()
            .options({
                transitionDuration: 50
            })
			.useInteractiveGuideline(true)
        ;
		chart.interpolate('basis');
		chart.useInteractiveGuideline(true)
		
        chart.xAxis
            .axisLabel("Input size")
            .tickFormat(d3.format(',.0f'))
            //.staggerLabels(true)
        ;

        chart.yAxis
            .axisLabel('Time (ms)')
            .tickFormat(function(d) {
                if (d == null) {
                    return 'N/A';
                }
                return d3.format(',.0f')(d);
            })
        ;

        d3.select('#chart1').append('svg')
            .datum(data)
            .call(chart);

        nv.utils.windowResize(chart.update);

        return chart;
    });

	
    /* function sinAndCos() {
        var sin = [],
            sin2 = [],
            cos = [],
            rand = [],
            rand2 = []
            ;

        for (var i = 0; i < 100; i++) {
            sin.push({x: i, y: i % 10 == 5 ? null : Math.sin(i/10) }); //the nulls are to show how defined works
            sin2.push({x: i, y: Math.sin(i/5) * 0.4 - 0.25});
            cos.push({x: i, y: .5 * Math.cos(i/10)});
            rand.push({x:i, y: Math.random() / 10});
            rand2.push({x: i, y: Math.cos(i/10) + Math.random() / 10 })
        }

		var alg1 = []
		alg1.push({x:0,y:0})
		alg1.push({x:50,y:0.026843000203371048})
		alg1.push({x:100,y:0.002764000091701746})
		alg1.push({x:150,y:0.0035520000383257866})
		alg1.push({x:150,y:0.002368000103160739})
		
		//[{"xaxis":200,"yaxis":,"algorithmCode":0,"algorithm":"BubbleSort"},{"xaxis":0,"yaxis":0.0,"algorithmCode":0,"algorithm":"BubbleSort"},{"xaxis":50,"yaxis":0.006711000110954046,"algorithmCode":0,"algorithm":"BubbleSort"},{"xaxis":100,"yaxis":0.002368000103160739,"algorithmCode":0,"algorithm":"BubbleSort"},{"xaxis":150,"yaxis":0.0015790000325068831,"algorithmCode":0,"algorithm":"BubbleSort"},{"xaxis":200,"yaxis":0.0015790000325068831,"algorithmCode":0,"algorithm":"BubbleSort"},{"xaxis":0,"yaxis":0.0,"algorithmCode":1,"algorithm":"SelectionSort"},{"xaxis":50,"yaxis":0.0027630000840872526,"algorithmCode":1,"algorithm":"SelectionSort"},{"xaxis":100,"yaxis":0.0011840000515803695,"algorithmCode":1,"algorithm":"SelectionSort"},{"xaxis":150,"yaxis":0.0015790000325068831,"algorithmCode":1,"algorithm":"SelectionSort"},{"xaxis":200,"yaxis":0.001973999897018075,"algorithmCode":1,"algorithm":"SelectionSort"},{"xaxis":0,"yaxis":0.0,"algorithmCode":0,"algorithm":"BubbleSort"},{"xaxis":50,"yaxis":0.008685000240802765,"algorithmCode":0,"algorithm":"BubbleSort"},{"xaxis":100,"yaxis":0.00355300004594028,"algorithmCode":0,"algorithm":"BubbleSort"},{"xaxis":150,"yaxis":0.002764000091701746,"algorithmCode":0,"algorithm":"BubbleSort"},{"xaxis":200,"yaxis":0.3687039911746979,"algorithmCode":0,"algorithm":"BubbleSort"},{"xaxis":0,"yaxis":0.0,"algorithmCode":1,"algorithm":"SelectionSort"},{"xaxis":50,"yaxis":0.01618500053882599,"algorithmCode":1,"algorithm":"SelectionSort"},{"xaxis":100,"yaxis":0.001973999897018075,"algorithmCode":1,"algorithm":"SelectionSort"},{"xaxis":150,"yaxis":0.0015790000325068831,"algorithmCode":1,"algorithm":"SelectionSort"},{"xaxis":200,"yaxis":0.0015780000248923898,"algorithmCode":1,"algorithm":"SelectionSort"},{"xaxis":0,"yaxis":0.0,"algorithmCode":2,"algorithm":"InsertionSort"},{"xaxis":50,"yaxis":0.0027630000840872526,"algorithmCode":2,"algorithm":"InsertionSort"},{"xaxis":100,"yaxis":0.0015790000325068831,"algorithmCode":2,"algorithm":"InsertionSort"},{"xaxis":150,"yaxis":0.0011840000515803695,"algorithmCode":2,"algorithm":"InsertionSort"},{"xaxis":200,"yaxis":0.0015790000325068831,"algorithmCode":2,"algorithm":"InsertionSort"}]
        return [
            //{
            //    area: true,
            //    values: sin,
            //    key: "Sine Wave",
            //    color: "#ff7f0e",
            //    strokeWidth: 4,
            //    classed: 'dashed'
            //},
            //{
            //    values: cos,
            //    key: "Cosine Wave",
            //    color: "#2ca02c"
            //},
			{
                values: alg1,
                key: "Bubble Sort",
                //color: "#2ca02c"
				color: colors[0]
            },
            //{
            //    values: rand,
            //    key: "Random Points",
            //    color: "#2222ff"
            //},
            //{
            //    values: rand2,
            //    key: "Random Cosine",
            //    color: "#667711",
            //    strokeWidth: 3.5
            //},
            //{
            //    area: true,
            //    values: sin2,
            //    key: "Fill opacity",
            //    color: "#EF9CFB",
            //    fillOpacity: .1
            //}
        ];
    } */
