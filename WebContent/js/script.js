function onSignIn(googleUser) 
{
      var profile = googleUser.getBasicProfile();
      var name = profile.getName();
      
      document.getElementById("nome").innerHTML =  name;
      document.getElementById("sair").style.display = "inline";
      $("#login-google").hide();
      
      if(window.location.href == "http://localhost:8080/Voxus/index.jsp")
      {
      document.getElementById("opcoes").style.display = "block";
      document.getElementById("nomeOpcoes").style.display = "block";
      }
      else if(window.location.href == "http://localhost:8080/Voxus/cadastro.jsp")
      {
      document.getElementById("cadastro").style.display = "block";
      }
      else if(window.location.href == "http://localhost:8080/Voxus/servlet?acao=listarTask")
      {
      document.getElementById("consultar").style.visibility = "visible";
      }
      else
      {
          document.getElementById("opcoes").style.display = "block";
          document.getElementById("nomeOpcoes").style.display = "block";
      }
        
      
   }
function sair() 
{
      gapi.auth2.getAuthInstance().disconnect();
      location.reload();
      window.location.replace("index.jsp");
      
}

function setUsuario()
{
	var a = document.getElementById('nome');
	var b = document.getElementById('nomeI');
	
	b.value = a.innerHTML;
}


