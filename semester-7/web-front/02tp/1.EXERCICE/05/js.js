window.addEventListener('load', function() {
    main();
});


function askDim(dim) {
    var row= prompt ( "Nombre de ligne : ", "(int)" );
    var column = prompt ( "Nombre de colonne : ", "(int)" );
    createTable(row, column);
}

function deleteTable() {
    var table = document.getElementById("table_multiplication");
    var nb_rows = table.rows.length;
    while (nb_rows > 0) {
        console.log(nb_rows);
        table.removeChild(table.firstChild);
        nb_rows = table.rows.length;
    }
}

function createTable(nb_row, nb_column) {
    var table = document.getElementById("table_multiplication");
    deleteTable();

    nb_row = Number(nb_row) + 2;
    nb_column = Number(nb_column) + 2;
    console.log(nb_row);
    console.log(nb_column);

    for (var i = 0; i < nb_row; i++) {
        var row = table.insertRow(i);
        for (var j = 0; j < nb_column; j++) {
            var cell = row.insertCell(j);
            //cell.innerHTML = "test " + i + j;
            if ( i == 0 && j == 0 ) {
                cell.appendChild(document.createTextNode(" "));
                cell.style.backgroundColor = "#0771aa";
            } else if ( i == 0 ) {
                cell.appendChild(document.createTextNode(table.rows[0].cells.length-2));
                cell.style.backgroundColor = "#0771aa";
            } else if ( j == 0 ) {
                cell.appendChild(document.createTextNode(table.rows.length-2));
                cell.style.backgroundColor = "#0771aa";
            } else {
                cell.appendChild(document.createTextNode((j-1)*(i-1)));
                console.log("ici " + Number(i + j));
            }
            cell.style.borderStyle = "solid";
            cell.style.borderBlockColor = "gray";
        }
    }
    table.style.backgroundColor = "lightgray";
    table.style.borderStyle = "solid";
    table.style.borderBlockColor = "gray";
    
}

function main() {

    const button = document.getElementById("bt");
    button.addEventListener("click", askDim );

}