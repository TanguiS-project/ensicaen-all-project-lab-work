const tabAnnee = ["1582", "1600", "1789", "1900", "1944", "1997", "2000", "2007", "2019", "2020"];
var ul = document.querySelector("ul");


function condition (params) {
    return params%4 == 0 && params%100 != 0 || params%400 == 0;
}

tabAnnee.forEach((item, index) => {
    const li = document.createElement("li");
    if ( condition ( Number ( item ) ) ) {
        li.appendChild(document.createTextNode(item + " est une année bissextiles"));
        li.style.color = "green";
    } else {
        li.appendChild(document.createTextNode(item + " n'est pas une année bissextiles"));
        li.style.color = "red";
    }
    ul.appendChild(li);
});