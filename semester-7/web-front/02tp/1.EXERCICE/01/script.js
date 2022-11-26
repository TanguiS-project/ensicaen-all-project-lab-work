var prix = 0;

var total = 0;
var produit = {
    carottes: [0, 5],
    asperges: [0, 10],
    cerises: [0, 20],
    oignons: [0, 3]
};

function add(name) {
    var number = prompt("Qté (en Kg)?", "(int)");
    produit[name][0] = Number(produit[name][0]) + Number(number);
    total += Number(number)*Number(produit[name][1]);
}

function popup() {
    if ( total == 0 ) {
        alert("Panier est vide !! UwU");
    } else {
        if (confirm("il faut payer : " + prix)) {
            location.reload();
        } 
    }
}

function popupPanier() {
    alert(
        "Votre panier : \n"
        + "carottes ("+produit.carottes[0]+" kg) : "+produit.carottes[0]*produit.carottes[1]+" euros\n"
        + "asperges ("+produit.asperges[0]+" kg) : "+produit.asperges[0]*produit.asperges[1]+" euros\n"
        + "cerises ("+produit.cerises[0]+" kg) : "+produit.cerises[0]*produit.cerises[1]+" euros\n"
        + "oignons ("+produit.oignons[0]+" kg) : "+produit.oignons[0]*produit.oignons[1]+" euros\n"
        + "total à payer : " + total + " euros"
    );
}