/**
 * 
 */

document.addEventListener("DOMContentLoaded", function(event) {
	exec();
});

function exec() {
	btnAccueil = document.getElementById('nav-accueil');
	btnAccueil.addEventListener('click', ()=>{
		alert("badaboum");
	});
}

function handleChangeLanguageSelect(value){
	if(value) {
		window.location.replace('?lang='+ value);
	}
}