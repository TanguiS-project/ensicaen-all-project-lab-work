const MAX_COLUMNS = 4;

window.addEventListener('load', function() {
    main();
});

function deleteTable() {
    var table = document.getElementById("table_carte");
    var nb_rows = table.rows.length;
    while (nb_rows > 0) {
        console.log(nb_rows);
        table.removeChild(table.firstChild);
        nb_rows = table.rows.length;
    }
}

function create32() {
    deleteTable();
    var table = document.getElementById("table_carte");
    var index = 1;
    for (var rows_index = 0; rows_index < Number ( 32 / 4 ); rows_index++) {
        var row = table.insertRow(2*rows_index);
        var row_name = table.insertRow(2*rows_index+1);
        for (let col_index = 0; col_index < MAX_COLUMNS; col_index++) {
            var cell = row.insertCell(col_index);
            var cell_name = row_name.insertCell(col_index);
            var img = document.createElement("img");
            img.src = "jeuxDeCartes/" + String(index)  + ".png";
            cell.appendChild(img);
            cell_name.appendChild(document.createTextNode(String(index)  + ".png"))
            cell_name.style.textAlign = "center";
            index = Number(index) + 1;
        }
    }
    var row = table.insertRow(table.rows.length);
    var row_name = table.insertRow(table.rows.length);
    var cell = row.insertCell(0);
    var cell_name = row_name.insertCell(0);
    var img = document.createElement("img");
    img.src = "jeuxDeCartes/b1fv.png";
    cell.appendChild(img);
    cell_name.appendChild(document.createTextNode("b1fv.png"));
    table.style.backgroundColor = "lightgray";
    table.style.borderStyle = "solid";
    table.style.borderBlockColor = "gray";
}

function create52() {
    deleteTable();
    var table = document.getElementById("table_carte");
    var index = 1;
    for (var rows_index = 0; rows_index < Number ( 52 / 4 ); rows_index++) {
        var row = table.insertRow(2*rows_index);
        var row_name = table.insertRow(2*rows_index+1);
        for (let col_index = 0; col_index < MAX_COLUMNS; col_index++) {
            var cell = row.insertCell(col_index);
            var cell_name = row_name.insertCell(col_index);
            var img = document.createElement("img");
            img.src = "jeuxDeCartes/" + String(index)  + ".png";
            cell.appendChild(img);
            cell_name.appendChild(document.createTextNode(String(index)  + ".png"))
            cell_name.style.textAlign = "center";
            index = Number(index) + 1;
        }
    }
    var row = table.insertRow(table.rows.length);
    var row_name = table.insertRow(table.rows.length);
    var cell = row.insertCell(0);
    var cell_name = row_name.insertCell(0);
    var img = document.createElement("img");
    img.src = "jeuxDeCartes/b1fv.png";
    cell.appendChild(img);
    cell_name.appendChild(document.createTextNode("b1fv.png"));
    table.style.backgroundColor = "lightgray";
    table.style.borderStyle = "solid";
    table.style.borderBlockColor = "gray";
}

function createTable ( number_card )
{
    if ( number_card == 32 ) {
        create32();
    } else if ( number_card == 52 ) {
        create52();
    } else {
        deleteTable();
    }
}


function main() {
    var select = document.getElementById("nb_carte");
    select.addEventListener('change', (event) => {
        //const number_card = Number(event.target.value);
        createTable ( event.target.value );
    });
}