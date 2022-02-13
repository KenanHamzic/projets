autoSave();

setInterval(function() {
	autoSave();
}, 5000);

var txt = document.getElementById("txt");
txt.value = localStorage.getItem("txt");

function autoSave() {
    localStorage.setItem("txt", txt.value);
}