var charDataStr = decodeHtml(chartData);
var charJsonArray = JSON.parse(charDataStr);

var arrayLength = charJsonArray.length;

var numericData = [];
var labelData = [];

for (var i = 0; i < arrayLength; i++) {
	numericData[i] = charJsonArray[i].value;
	labelData[i] = charJsonArray[i].label;	
}
// for pie chart
new Chart(document.getElementById("myPieChart"), {
	type: 'pie', 
	// The data for our dataset
    data: {
        labels: labelData,
        datasets: [{
            label: 'My First dataset',
            backgroundColor: ["#FF5733","#DAF7A6 ","#C70039"],
            borderColor: 'rgb(255, 99, 132)',
            data: numericData
        }]
    },

    // Configuration options go here
    options: {
    	
    	title: {
    		display:true,
    		text: 'project Status'
    	}
    }
});

function decodeHtml(html){
	// [{"value":1,"label":"COMPLETED"},{"value":2,"label":"INPROGRESS"},{"value":1,"label":"NOTSTARTED"}]
	var txt = document.createElement("textarea");
	txt.innerHTML = html;
	return txt.value;
}