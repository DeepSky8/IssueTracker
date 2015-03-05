var inputs = $("input");
var button = $("button");    
    
button.attr('disabled', true);

inputs.keyup(function() {
    var trigger = false;
    inputs.each(function() {
       trigger = trigger || !$(this).val();
    });
    trigger ? button.attr('disabled', true) : button.removeAttr('disabled');
});