var inputs = $("input");
var button = $("button");    
    
button.attr('disabled', true);

inputs.keyup(function() {
    var trigger = trigger = trigger || !$(this).val();
    inputs.each(function() {
        if (!$(this).val()) {
            trigger = true;
        }
    });
    trigger ? button.attr('disabled', true) : button.removeAttr('disabled');
});