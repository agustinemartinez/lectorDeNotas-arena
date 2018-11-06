
$(document).ready(function() {
	$('#btn-enter')
	.on('beforeSend.ic', function() {

	})
	.on('complete.ic', function() {
		location.reload();
		//$( location ).attr("href", "http://localhost:9000/");
	});
});
