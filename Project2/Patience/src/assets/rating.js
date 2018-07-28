$('.rating input').change(function () {
  var $radio = $(this);
  console.log("pressed");
  $('.rating .selected').removeClass('selected');
  $radio.closest('label').addClass('selected');
});