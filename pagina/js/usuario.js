function carregarUsuario(){
    var usuarioLogado = localStorage.getItem("user");
    if (!usuarioLogado){
        window.location="index.html";
    }else{
        var usuarioJson = JSON.parse(usuarioLogado);
        document.getElementById("dados").innerHTML=
        "<h3 id='nomeUsuario'>" + usuarioJson.nome + "</h3>" ;
        

        document.getElementById("foto").innerHTML=
        "<img width='50%' alt='Imagem não encontrada' src=Images/" + usuarioJson.foto + ">";

    }
}


function logout(){
    localStorage.removeItem("user");
    window.location="index.html";
}