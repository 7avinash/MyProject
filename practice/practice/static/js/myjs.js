// All the java script goes here

window.onload = initialize;
var data = [{
		'name':"avinash",
		'age':19
	},
	{
		'name':"abc",
		'age':18
	}
];

function draw(data){
	d3.select("div.container")
	.append("ul")
	.selectAll("li")
	.data(data)
	.enter().append("li")
	.text(function(d){
		return d.name+": "+d.age;
	});
}

function test(){
	return "Avinash"
}

var data_json = test();
function initialize(){
	draw(data);
}
d3.csv("/static/js/Loop_Business\ Plan.csv")
    .row(function(d) { if (d.Aggregator=="Devinder" || d.Aggregator == "Ranjeet"){return {key: d.Aggregator, value: +d['Cost per kg']};} })
    .get(function(error, rows) { console.log(rows); });
