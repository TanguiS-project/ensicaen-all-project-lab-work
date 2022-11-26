var current_index = 1;
var max_index = 52

window.addEventListener('load', function() {
    main();
});

function updateImg()
{
    var img = document.getElementById('img');
    img.src = "jeuxDeCartes/" + String(current_index)  + ".png";
}

function updateCurrent()
{
    var current = document.getElementById('current');
    current.value = Number(current_index);
}

function updateMax()
{
    var max = document.getElementById('max');
    max.value = Number(max_index);

}

function incrementIndex() {
    if ( Number(current_index) == max_index ) {
        return;
    }
    current_index++;
    updateImg();
    updateCurrent();
}

function decrementIndex()
{
    if ( Number(current_index) == 1 ) {
        return;
    }
    current_index--;
    updateImg();
    updateCurrent(); 
}

function goToFirst()
{
    current_index = 1;
    updateImg();
    updateCurrent(); 
}

function goToMax()
{
    current_index = max_index;
    updateImg();
    updateCurrent(); 
}

function modifyCurrentIndex()
{
    var current = document.getElementById('current').value;
    console.log("current index : " + current );
    if ( Number(current) > Number(max_index) || Number(current) < 1 ) {
        updateCurrent();
        return;
    }
    current_index = current;
    updateImg();
    updateCurrent();
}

function modifyMaxIndex()
{
    var max = document.getElementById('max').value;
    console.log("max index : " + max );
    if ( Number(max) > Number(max_index) || Number(max) < 1 ) {
        return;
    }
    max_index = max;
    if ( Number(current_index) > max_index ) {
        current_index = max_index;
        updateImg();
        updateCurrent();
    }
    updateMax();
}

function main()
{
    updateImg();
    updateCurrent();
    updateMax();
    var previous = document.getElementById('previous');
    var next = document.getElementById('next');
    var first = document.getElementById('first');
    var last = document.getElementById('last');
    var current = document.getElementById('current');
    var max = document.getElementById('max');

    previous.addEventListener('click', decrementIndex);
    next.addEventListener('click', incrementIndex);
    first.addEventListener('click', goToFirst);
    last.addEventListener('click', goToMax);
    current.addEventListener('input', modifyCurrentIndex);
    max.addEventListener('input', modifyMaxIndex);

}