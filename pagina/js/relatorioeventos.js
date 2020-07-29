function checarUsuario(){
    var usuarioLogado = localStorage.getItem("user");
    if (!usuarioLogado){
        window.location="index.html";
    }else{

    }
}

function logout(){
    localStorage.removeItem("user");
    window.location="index.html";
}



function gerarRelatorioEventos(){
    window.alert("data " +  document.getElementById("txtInicio").value);
    window.alert("data " +  document.getElementById("txtFim").value );

var dados={
    inicio:document.getElementById("txtInicio").value,
    fim:document.getElementById("txtFim").value  
}

var pacote={
    method:"POST",
    body:JSON.stringify(dados),
    headers:{
        "Content-type":"application/json"
    }
}

 fetch("http://localhost:8080/eventos/intervalo", pacote)
        .then(res => res.json())
        .then(res => {
            
            localStorage.setItem("user",JSON.stringify(res));
            window.location="relatorioeventos.html";
        })
        .then(res => carregarRelatorio(res))
        
        .catch(err=> {
            window.alert("Erro");
        });
}


function popularTabela(lista){
    var strEventos = 
        "<div class='row'> <div class='col-12'>" + 
        "<table border='1' cellpadding='15' width='80%' align='center'>" + 
        "<tr>" + 
            "<td>Data</td>" + 
            "<td>Alarme</td>"+
            "<td>Equipamento</td>" +
        "</tr>";
 
        for (cont=0; cont<lista.length;cont++){
            strEventos+=
            "<tr>"+
            "<td>" + lista[cont].data + "</td>" +
            "<td>" + lista[cont].alarme.descricao + "</td>" +
            "<td>" + lista[cont].equipamento.hostname + "</td>" +
            "</tr>";  
        }
        strEventos+="</table></div></div>";
        document.getElementById("eventos").innerHTML = strEventos;
}

function carregarRelatorio(){

    var usuario = localStorage.getItem("user");
    if (!usuario){
        window.location="index.html";
    }else{

        var dados={
            inicio:document.getElementById("txtInicio").value,
            fim:document.getElementById("txtFim").value  
        }
        
        var pacote={
            method:"POST",
            body:JSON.stringify(dados),
            headers:{
                "Content-type":"application/json"
            }
        }

        fetch("http://localhost:8080/eventos/intervalo" , pacote)
        .then(res =>res.json())
        .then(res => popularTabela(res));
    }
}











