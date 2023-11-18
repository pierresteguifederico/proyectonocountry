function goBackToTop() {
  window.addEventListener('scroll', () => {

    var scroll = document.documentElement.scrollTop;
    var arrowUp = document.getElementById("arrowUp");

    if (scroll > 400) {
      arrowUp.style.right = 28 + "px"

    }else{
      arrowUp.style.right = -100 + "px"

    }

  })
}

goBackToTop();
