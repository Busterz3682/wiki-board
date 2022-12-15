$('#searchInput').keyup(function(){
	  let s = $('#searchInput').val()
	  console.log(s)
	  $.ajax({
		  type : 'get',
		  url : '/wiki/searchDoc',
		  data : {"search" : s},
		  success : function(result){
			  console.log(result);
			  $('#searchResult').empty();
			  for(let i = 0; i < (result.length < 10 ? result.length : 10); i++) {
				  $('#searchResult').append("<li><a href='http://localhost:8181/wiki/getDoc/"+result[i]+"'>"+result[i]+"</a></li>")
			  }
		  },
		  error : function() {
			  console.log('no result');
		  }
  });
});