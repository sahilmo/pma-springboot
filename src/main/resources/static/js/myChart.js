new Chart(document.getElementById("myPieChart"), {
	type: 'pie', 
	// The data for our dataset
    data: {
        labels: ['January', 'February', 'March'],
        datasets: [{
            label: 'My First dataset',
            backgroundColor: ["#FF5733","#DAF7A6 ","#C70039"],
            borderColor: 'rgb(255, 99, 132)',
            data: [30, 30, 40]
        }]
    },

    // Configuration options go here
    options: {}
});