    var $input = $("input"),
    $button = $("button");    
$button.attr('disabled', true);

$input.keyup(function() {
    var trigger = false;
    $input.each(function() {
        if (!$(this).val()) {
            trigger = true;
        }
    });
    trigger ? $button.attr('disabled', true) : $button.removeAttr('disabled');
});