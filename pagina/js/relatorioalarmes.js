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

function logout3(){
    localStorage.removeItem("user");
    window.location="index.html";
}


function logout2(){
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

 fetch("http://localhost:8080/eventos/alarme", pacote)
        .then(res => res.json())
        .then(res => {
            
            localStorage.setItem("user",JSON.stringify(res));
            window.location="relatorioalarmes.html";
        })
        .then(res => carregarRelatorio(res))
        
        .catch(err=> {
            window.alert("Erro");
        });
}


function popularTabela(lista){
    var strAlarmes = 
        "<div class='row'> <div class='col-12'>" + 
        "<table border='1' cellpadding='15' width='80%' align='center'>" + 
        "<tr>" + 
            
            "<td>Alarme</td>"+
            "<td>Quantidade no Periodo</td>" +
        "</tr>";
 
        for (cont=0; cont<lista.length;cont++){
            strAlarmes+=
            "<tr>"+
            "<td>" + lista[cont].descricao + "</td>" +
            "<td>" + lista[cont].qtd_alarme + "</td>" +
            "</tr>";  
        }
        strAlarmes+="</table></div></div>";
        document.getElementById("alarmes").innerHTML = strAlarmes;
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

        fetch("http://localhost:8080/eventos/alarme" , pacote)
        .then(res =>res.json())
        .then(res => popularTabela(res));
    }
}













