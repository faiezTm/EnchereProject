var TableData = function() {
	"use strict";
	//function to initiate DataTable
	//DataTable is a highly flexible tool, based upon the foundations of progressive enhancement,
	//which will add advanced interaction controls to any HTML table
	//For more information, please visit https://datatables.net/
	var runDataTable_articleEnchereAnglaise = function() {
		var newRow = false;
		var actualEditingRow = null;

		function restoreRow(oTable, nRow) {
			var aData = oTable.fnGetData(nRow);
			var jqTds = $('>td', nRow);

			for (var i = 0, iLen = jqTds.length; i < iLen; i++) {
				oTable.fnUpdate(aData[i], nRow, i, false);
			}

			oTable.fnDraw();
		}

		function editRow(oTable, nRow) {
			var aData = oTable.fnGetData(nRow);
			var jqTds = $('>td', nRow);
			jqTds[0].innerHTML = '<textarea class="form-control" style="margin: 0px; width: 200px; height: 50px;" name = "description"> '+ aData[0] + ' </textarea>';
			jqTds[1].innerHTML = '<textarea class="form-control" style="margin: 0px; width: 200px; height: 50px;" name = "definition_article">'+ aData[1] + '</textarea>';

			jqTds[2].innerHTML = '<input type="text" class="form-control" style="margin: 0px; width: auto; height: auto;" value="' + aData[2] + '">';
			jqTds[3].innerHTML = '<input type="text" class="form-control" style="margin: 0px; width: auto; height: auto;" value="' + aData[3] + '">';
			jqTds[4].innerHTML = '<input type="text" class="form-control" style="margin: 0px; width: auto; height: auto;" value="' + aData[4] + '">';
			jqTds[5].innerHTML = '<input type="text" class="form-control" style="margin: 0px; width: auto; height: auto;" value="' + aData[5] + '">';
			jqTds[6].innerHTML = '<input type="text" class="form-control" style="margin: 0px; width: auto; height: auto;" value="' + aData[6] + '">';
			jqTds[7].innerHTML = '<input type="text" class="form-control" style="margin: 0px; width: auto; height: auto;" value="' + aData[7] + '">';
			jqTds[8].innerHTML = '<input type="text" class="form-control" style="margin: 0px; width: auto; height: auto;" value="' + aData[8] + '">';
			jqTds[9].innerHTML = '<input type="text" class="form-control" style="margin: 0px; width: auto; height: auto;" value="' + aData[9] + '">';			
			jqTds[10].innerHTML = '<a class="save-row" href="">Save</a>';
			jqTds[11].innerHTML = '<a class="cancel-row" href="">Cancel</a>';

		}

		function saveRow(oTable, nRow) {
			var jqInputs = $('input', nRow);
			oTable.fnUpdate(jqInputs[0].value, nRow, 0, false);
			oTable.fnUpdate(jqInputs[1].value, nRow, 1, false);
			oTable.fnUpdate(jqInputs[2].value, nRow, 2, false);
			oTable.fnUpdate('<a class="edit-row" href="">Edit</a>', nRow, 3, false);
			oTable.fnUpdate('<a class="delete-row" href="">Delete</a>', nRow, 4, false);
			oTable.fnDraw();
			newRow = false;
			actualEditingRow = null;
		}

		$('body').on('click', '.add-articleEnchereAnglaise', function(e) {
			e.preventDefault();
			if (newRow == false) {
				if (actualEditingRow) {
					restoreRow(oTable, actualEditingRow);
				}
				newRow = true;
				var aiNew = oTable.fnAddData(['', '', '', '', '', '', '', '', '', '', '', '']);
				var nRow = oTable.fnGetNodes(aiNew[0]);
				editRow(oTable, nRow);
				actualEditingRow = nRow;
			}
		});
		$('#articleEnchereAnglaise').on('click', '.cancel-row', function(e) {

			e.preventDefault();
			if (newRow) {
				newRow = false;
				actualEditingRow = null;
				var nRow = $(this).parents('tr')[0];
				oTable.fnDeleteRow(nRow);

			} else {
				restoreRow(oTable, actualEditingRow);
				actualEditingRow = null;
			}
		});
		$('#articleEnchereAnglaise').on('click', '.delete-row', function(e) {
			e.preventDefault();
			if (newRow && actualEditingRow) {
				oTable.fnDeleteRow(actualEditingRow);
				newRow = false;

			}
			var nRow = $(this).parents('tr')[0];
			bootbox.confirm("Are you sure to delete this row?", function(result) {
				if (result) {
					$.blockUI({
					message : '<i class="fa fa-spinner fa-spin"></i> Do some ajax to sync with backend...'
					});
					$.mockjax({
						url : '/tabledata/delete/webservice',
						dataType : 'json',
						responseTime : 1000,
						responseText : {
							say : 'ok'
						}
					});
					$.ajax({
						url : '/tabledata/delete/webservice',
						dataType : 'json',
						success : function(json) {
							$.unblockUI();
							if (json.say == "ok") {
							oTable.fnDeleteRow(nRow);
							}
						}
					});				
					
				}
			});
			

			
		});
		$('#articleEnchereAnglaise').on('click', '.save-row', function(e) {
			e.preventDefault();

			var nRow = $(this).parents('tr')[0];
			$.blockUI({
					message : '<i class="fa fa-spinner fa-spin"></i> Do some ajax to sync with backend...'
					});
					$.mockjax({
						url : '/tabledata/add/webservice',
						dataType : 'json',
						responseTime : 1000,
						responseText : {
							say : 'ok'
						}
					});
					$.ajax({
						url : '/tabledata/add/webservice',
						dataType : 'json',
						success : function(json) {
							$.unblockUI();
							if (json.say == "ok") {
								saveRow(oTable, nRow);
							}
						}
					});	
		});
		
		$('#articleEnchereAnglaise').on('click', '.edit-row', function(e) {
			e.preventDefault();
			if (actualEditingRow) {
				if (newRow) {
					oTable.fnDeleteRow(actualEditingRow);
					newRow = false;
				} else {
					restoreRow(oTable, actualEditingRow);

				}
			}
			var nRow = $(this).parents('tr')[0];
			editRow(oTable, nRow);
			actualEditingRow = nRow;

		});
		var oTable = $('#articleEnchereAnglaise').dataTable({
			"aoColumnDefs" : [{
				"aTargets" : [0]
			}],
			"oLanguage" : {
				"sLengthMenu" : "Show _MENU_ Rows",
				"sSearch" : "",
				"oPaginate" : {
					"sPrevious" : "",
					"sNext" : ""
				}
			},
			"aaSorting" : [[1, 'asc']],
			"aLengthMenu" : [[5, 10, 15, 20, -1], [5, 10, 15, 20, "All"] // change per page values here
			],
			// set the initial value
			"iDisplayLength" : 5,
		});
		$('#articleEnchereAnglaise_wrapper .dataTables_filter input').addClass("form-control input-sm").attr("placeholder", "Search");
		// modify table search input
		$('#articleEnchereAnglaise_wrapper .dataTables_length select').addClass("m-wrap small");
		// modify table per page dropdown
		$('#articleEnchereAnglaise_wrapper .dataTables_length select').select2();
		// initialzie select2 dropdown
		$('#articleEnchereAnglaise_column_toggler input[type="checkbox"]').change(function() {
			/* Get the DataTables object again - this is not a recreation, just a get of the object */
			var iCol = parseInt($(this).attr("data-column"));
			var bVis = oTable.fnSettings().aoColumns[iCol].bVisible;
			oTable.fnSetColumnVis(iCol, ( bVis ? false : true));
		});
	};
	
	var runDataTable_articleEnchereHollandaise = function() {
		var newRow = false;
		var actualEditingRow = null;
		var imgToUpload ;
		function restoreRow(oTable, nRow) {
			var aData = oTable.fnGetData(nRow);
			var jqTds = $('>td', nRow);

			for (var i = 0, iLen = jqTds.length; i < iLen; i++) {
				oTable.fnUpdate(aData[i], nRow, i, false);
			}

			oTable.fnDraw();
		}

		function editArticleEnchereHollandaise(oTable, nRow) {
			var aData = oTable.fnGetData(nRow);
			var jqTds = $('>td', nRow);
			
			jqTds[0].innerHTML = '<textarea id = "description" class="form-control" style="margin: 0px; width: 200px; height: 50px;" name = "description">' + aData[0] + '</textarea>';
			jqTds[1].innerHTML = '<textarea id = "definitionArt" class="form-control" style="margin: 0px; width: 200px; height: 50px;" name = "definition_article">' + aData[1] + '</textarea>';

			jqTds[2].innerHTML = '<input type="text" id = "prixInit" class="form-control" style="margin: 0px; width: auto; height: auto;" value="' + aData[2] + '">';
			jqTds[3].innerHTML = '<input type="text" id = "prixReserve" class="form-control" style="margin: 0px; width: auto; height: auto;" value="' + aData[3] + '">';
			jqTds[4].innerHTML = '<input type="text" id = "pays" class="form-control" style="margin: 0px; width: auto; height: auto;" value="' + aData[4] + '">';
			jqTds[5].innerHTML = '<input type="text" id = "lieu" class="form-control" style="margin: 0px; width: auto; height: auto;" value="' + aData[5] + '">';
			jqTds[6].innerHTML = '<input type="text" id = "region" class="form-control" style="margin: 0px; width: auto; height: auto;" value="' + aData[6] + '">';
			jqTds[7].innerHTML = '<input type="text" id = "photo" class="form-control" style="margin: 0px; width: auto; height: auto;" value="' + aData[7] + '">';
			jqTds[8].innerHTML = '<input type="text" id = "visibiliteReserve" class="form-control" style="margin: 0px; width: auto; height: auto;" value="' + aData[8] + '">';
			jqTds[9].innerHTML = '<input type="text" id = "qteArticle" class="form-control" style="margin: 0px; width: auto; height: auto;" value="' + aData[9] + '">';
			jqTds[10].innerHTML = '<input type="text" id = "dateDebut" class="form-control" style="margin: 0px; width: auto; height: auto;" value="' + aData[10] + '">';
			jqTds[11].innerHTML = '<input type="text" id = "dateFin" class="form-control" style="margin: 0px; width: auto; height: auto;" value="' + aData[11] + '">';

			
			jqTds[12].innerHTML = '<a class="editArticleEnchereHollandaise">Edit</a>';
			jqTds[13].innerHTML = '<a class="cancel-row" href="">Cancel</a>';

		}
		
		$('body').on('click', '.editArticleEnchereHollandaise', function(e) {
			e.preventDefault();
			var description = document.getElementById("description").value;
			var definitionArt = document.getElementById("definitionArt").value;
			var prixInit = document.getElementById("prixInit").value;
			var prixReserve = document.getElementById("prixReserve").value;
			var pays = document.getElementById("pays").value;
			var lieu = document.getElementById("lieu").value;
			var region = document.getElementById("region").value;
			var visibiliteReserve = document.getElementById("visibiliteReserve").value;
			var qteArticle = document.getElementById("qteArticle").value;
			var dateDebut = document.getElementById("dateDebut").value;
			var dateFin = document.getElementById("dateFin").value;
			window.location.replace('../../Enchere/AddArticle?description='+description+'&definitionArt='+definitionArt+'&prixInit='+prixInit+'&prixReserve='+prixReserve+'&pays='+pays+'&lieu='+lieu+'&region='+region+'&visibiliteReserve='+visibiliteReserve+'&qteArticle='+qteArticle+'&dateDebut='+dateDebut+'&dateFin='+dateFin+'&typeEnchere=hollandaise');
		});
		
		function saveArtEnchereHollandaise(oTable, nRow) {
			var jqTds = $('>td', nRow);
			jqTds[0].innerHTML = '<textarea id = "description" class="form-control" style="margin: 0px; width: 200px; height: 50px;" name = "description"></textarea>';
			jqTds[1].innerHTML = '<textarea id = "definitionArt" class="form-control" style="margin: 0px; width: 200px; height: 50px;" name = "definition_article"></textarea>';

			jqTds[2].innerHTML = '<input type="number" id = "prixInit" class="form-control" style="margin: 0px; width: auto; height: auto;">';
			jqTds[3].innerHTML = '<input type="number" id = "prixReserve" class="form-control" style="margin: 0px; width: auto; height: auto;">';
			jqTds[4].innerHTML = '<input type="text" id = "pays" class="form-control" style="margin: 0px; width: auto; height: auto;">';
			jqTds[5].innerHTML = '<input type="text" id = "lieu" class="form-control" style="margin: 0px; width: auto; height: auto;">';
			jqTds[6].innerHTML = '<input type="text" id = "region" class="form-control" style="margin: 0px; width: auto; height: auto;">';
			jqTds[7].innerHTML = '<input type="file" id = "photo" accept="image/*" class="form-control" style="margin: 0px; width: auto; height: auto;"> <img id="imgToUpload" src="#" alt="your image" />';
			jqTds[8].innerHTML = '<div style="display:block; width: 150px;" > Visible  <input type="radio" id = "visibiliteReserve" name = "visibiliteReserve"/>  Non visible  <input type="radio" id = "visibiliteReserve" name = "visibiliteReserve""/></div>';
			jqTds[9].innerHTML = '<input type="number" id = "qteArticle" class="form-control" style="margin: 0px; width: auto; height: auto;">';
			jqTds[10].innerHTML = '<input type="datetime-local" id = "dateDebut">';
			jqTds[11].innerHTML = '<input type="datetime-local" id = "dateFin"/>';

			
			jqTds[12].innerHTML = '<a class="saveArticleEnchereHollandaise">Save</a>';
			jqTds[13].innerHTML = '<a class="cancel-row" href="">Cancel</a>';

		}
		$('body').on('change', '#photo', function(e) {
			console.log("test");
			var input = this;
			if (input.files && input.files[0]) {
	            var reader = new FileReader();

	            reader.onload = function (e) {
	                $('#imgToUpload')
	                    .attr('src', e.target.result)
	                    .width(100)
	                    .height(100);
	                imgToUpload = e.target.result;
	                console.log(imgToUpload);
	            };

	            reader.readAsDataURL(input.files[0]);
	        }
		});
		
		$('body').on('click', '.saveArticleEnchereHollandaise', function(e) {
			e.preventDefault();
			var description = document.getElementById("description").value;
			var definitionArt = document.getElementById("definitionArt").value;
			var prixInit = document.getElementById("prixInit").value;
			var prixReserve = document.getElementById("prixReserve").value;
			var pays = document.getElementById("pays").value;
			var lieu = document.getElementById("lieu").value;
			var region = document.getElementById("region").value;
			var visibiliteReserve = document.getElementById("visibiliteReserve").checked;
			var qteArticle = document.getElementById("qteArticle").value;
			var dateDebut = document.getElementById("dateDebut").value;
			var dateFin = document.getElementById("dateFin").value;
			console.log(dateDebut);
			console.log(dateFin);
			
			$.ajax({
				url: '../../Enchere/AddArticle',
				type: 'POST',
				data:{description:description,definitionArt: definitionArt,prixInit: prixInit,prixReserve: prixReserve,pays: pays,lieu: lieu,region: region,visibiliteReserve: visibiliteReserve,qteArticle: qteArticle,dateDebut: dateDebut,dateFin: dateFin,photo:imgToUpload,typeEnchere:'hollandaise'},
				dataType:'json',
				enctype: 'multipart/form-data',
				success: function (data, textStatus, xhr) {
				
				}
			});
			/*$.post("../../Enchere/AddArticle",
			        {
					description : ''+description,
					definitionArt: definitionArt,
					prixInit: prixInit,
					prixReserve: prixReserve,
					pays: pays,
					lieu: lieu,
					region: region,
					visibiliteReserve: visibiliteReserve,
					qteArticle: qteArticle,
					dateDebut: dateDebut,
					dateFin: dateFin,
					photo: JSON.stringify({image: imgToUpload})
			    }, function(response, status) {
			        // notify user that his order is successfull
			        }
			);*/
			//window.location.replace('../../Enchere/AddArticle?description='+description+'&definitionArt='+definitionArt+'&prixInit='+prixInit+'&prixReserve='+prixReserve+'&pays='+pays+'&lieu='+lieu+'&region='+region+'&visibiliteReserve='+visibiliteReserve+'&qteArticle='+qteArticle+'&dateDebut='+dateDebut+'&dateFin='+dateFin+'&typeEnchere=hollandaise'+'&photo='+image+'');
		});
		function saveArticleEnchereHollandaise(oTable, nRow) {
			var jqInputs = $('input', nRow);
			oTable.fnUpdate(jqInputs[0].value, nRow, 0, false);
			oTable.fnUpdate(jqInputs[1].value, nRow, 1, false);
			oTable.fnUpdate(jqInputs[2].value, nRow, 2, false);
			oTable.fnUpdate('<a class="edit-row" href="">Edit</a>', nRow, 3, false);
			oTable.fnUpdate('<a class="delete-row" href="">Delete</a>', nRow, 4, false);
			oTable.fnDraw();
			newRow = false;
			actualEditingRow = null;
		}

		$('body').on('click', '.add-articleEnchereHollandaise', function(e) {
			e.preventDefault();
			if (newRow == false) {
				if (actualEditingRow) {
					restoreRow(oTable, actualEditingRow);
				}
				newRow = true;
				var aiNew = oTable.fnAddData(['', '', '', '', '', '', '', '', '', '', '', '', '', '']);
				var nRow = oTable.fnGetNodes(aiNew[0]);
				saveArtEnchereHollandaise(oTable, nRow);
				actualEditingRow = nRow;
			}
		});
		$('#articleEnchereHollandaise').on('click', '.cancel-row', function(e) {

			e.preventDefault();
			if (newRow) {
				newRow = false;
				actualEditingRow = null;
				var nRow = $(this).parents('tr')[0];
				oTable.fnDeleteRow(nRow);

			} else {
				restoreRow(oTable, actualEditingRow);
				actualEditingRow = null;
			}
		});
		$('#articleEnchereHollandaise').on('click', '.delete-row', function(e) {
			e.preventDefault();
			if (newRow && actualEditingRow) {
				oTable.fnDeleteRow(actualEditingRow);
				newRow = false;

			}
			var nRow = $(this).parents('tr')[0];
			bootbox.confirm("Are you sure to delete this row?", function(result) {
				if (result) {
					$.blockUI({
					message : '<i class="fa fa-spinner fa-spin"></i> Do some ajax to sync with backend...'
					});
					$.mockjax({
						url : '/tabledata/delete/webservice',
						dataType : 'json',
						responseTime : 1000,
						responseText : {
							say : 'ok'
						}
					});
					$.ajax({
						url : '/tabledata/delete/webservice',
						dataType : 'json',
						success : function(json) {
							$.unblockUI();
							if (json.say == "ok") {
							oTable.fnDeleteRow(nRow);
							}
						}
					});				
					
				}
			});
			

			
		});
		
		$('#articleEnchereHollandaise').on('click', '.editArticleEnchereHollandaise', function(e) {
			e.preventDefault();
			if (actualEditingRow) {
				if (newRow) {
					oTable.fnDeleteRow(actualEditingRow);
					newRow = false;
				} else {
					restoreRow(oTable, actualEditingRow);

				}
			}
			var nRow = $(this).parents('tr')[0];
			editArticleEnchereHollandaise(oTable, nRow);
			actualEditingRow = nRow;

		});
		var oTable = $('#articleEnchereHollandaise').dataTable({
			"aoColumnDefs" : [{
				"aTargets" : [0]
			}],
			"oLanguage" : {
				"sLengthMenu" : "Show _MENU_ Rows",
				"sSearch" : "",
				"oPaginate" : {
					"sPrevious" : "",
					"sNext" : ""
				}
			},
			"aaSorting" : [[1, 'asc']],
			"aLengthMenu" : [[5, 10, 15, 20, -1], [5, 10, 15, 20, "All"] // change per page values here
			],
			// set the initial value
			"iDisplayLength" : 5,
		});
		$('#articleEnchereHollandaise_wrapper .dataTables_filter input').addClass("form-control input-sm").attr("placeholder", "Search");
		// modify table search input
		$('#articleEnchereHollandaise_wrapper .dataTables_length select').addClass("m-wrap small");
		// modify table per page dropdown
		$('#articleEnchereHollandaise_wrapper .dataTables_length select').select2();
		// initialzie select2 dropdown
		$('#articleEnchereHollandaise_column_toggler input[type="checkbox"]').change(function() {
			/* Get the DataTables object again - this is not a recreation, just a get of the object */
			var iCol = parseInt($(this).attr("data-column"));
			var bVis = oTable.fnSettings().aoColumns[iCol].bVisible;
			oTable.fnSetColumnVis(iCol, ( bVis ? false : true));
		});
	};
	return {
		//main function to initiate template pages
		init : function() {
			runDataTable_articleEnchereAnglaise();
			runDataTable_articleEnchereHollandaise();
		}
	};
}();
