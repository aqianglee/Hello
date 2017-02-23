$('.dialog').wrap('<div class="dialog-background">');

$('.dialog').prepend('<a href="#" class="close">close</a>');

var margin = ($('.dialog-background').height() - $('.dialog').height()) / 2;
$('.dialog').css('margin', margin + 'px auto');

$("[data-target='dialog']").click(function() {
    var target = $(this).attr('href');
    $('#' + target).parent().show();
    $('#' + target).show();
    return false;
});

$('.close').click(function() {
    var target = $(this).parent();
    target.hide();
    target.parent().hide();
});
