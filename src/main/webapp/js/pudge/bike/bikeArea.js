$(function () {
	
	var rootPath=getRootPath();
	
	
    var bike_area_highchar =function(bikeAreaNames,bikes){
    	
    	$('#container').highcharts({
            chart: {
                type: 'column'
            },
            title: {
                text: 'Monthly Average Rainfall'
            },
            subtitle: {
                text: 'Source: WorldClimate.com'
            },
            xAxis: {
                categories: bikeAreaNames
            },
            yAxis: {
                min: 0,
                title: {
                    text: 'Rainfall (辆)'
                }
            },
            tooltip: {
                headerFormat: '<span style="font-size:10px">{point.key}</span><table>',
                pointFormat: '<tr><td style="color:{series.color};padding:0">{series.name}: </td>' +
                    '<td style="padding:0"><b>{point.y:.1f} 辆</b></td></tr>',
                footerFormat: '</table>',
                shared: true,
                useHTML: true
            },
            plotOptions: {
                column: {
                    pointPadding: 0.2,
                    borderWidth: 0
                }
            },
            series: bikes
        });
    } 
	
	$.ajax({
		type: "POST",
		url:rootPath+"/bikeArea_manage/statBikArea.do?t"+new Date().getTime(),
		dataType: "json",
		success: function(data){
			if(data!=null){
				var bikeAreaNames = data.bikeAreaNames;
				var bikes = data.bikes;
				bike_area_highchar(bikeAreaNames,bikes);
			}
			
		}
	});
	
	
	
	
	
	
   
    });