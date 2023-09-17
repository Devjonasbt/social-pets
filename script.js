function menuMobile(){
    const activeMenu = document.querySelector('.fa-bars');
    const navMenu = document.querySelector('header .navegacao-primaria');
    
    
    activeMenu.addEventListener('click',()=>{
        activeMenu.classList.toggle('fa-x');
        navMenu.classList.toggle('ativado');
    });

}
var images = [
    "assets/past-pet/pet1.jpg",
    "assets/past-pet/pet2.webp",
    "assets/past-pet/pet3.jpg",
    "assets/past-pet/pet4.jpg"
];
var cont=0;
function backImg(){
   var bg = document.getElementById('bg');
   var index = Math.floor(Math.random()*images.length);
   bg.style.backgroundImage='url('+images[index]+')';
}
setInterval(backImg, 3000);