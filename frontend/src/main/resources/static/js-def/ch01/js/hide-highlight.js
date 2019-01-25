function hide(element, reflow) {

	if (reflow) {
		element.style.display = "none";
	} else {
		element.style.display = "hidden";
	}
}

function highlight(e) {
	if (!e.className) {
		e.className = "hilite";
	} else {
		e.className += "hilite";
	}
}