const box = document.querySelector(".container");
const img = document.querySelectorAll(".container img");

let contador=0;
function carrossel(){
    contador++;
    if(contador > img.length - 1){
        idx = 0;
    }
     box.style.transform = 'translateX(${-contador * 1250}px)';
}
setInterval(carrossel, 1800);