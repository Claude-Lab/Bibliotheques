<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
 <nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top" id="mainNav">
    <div class="container">
      <a class="navbar-brand js-scroll-trigger" href="accueil">Bibliothèque</a>
      <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
      </button>
      <div class="collapse navbar-collapse" id="navbarResponsive">
        <ul class="navbar-nav ml-auto">
          <li class="nav-item">
            <a class="nav-link js-scroll-trigger" href="accueil">Accueil</a>
          </li>
          <li class="nav-item">
            <a class="nav-link js-scroll-trigger" href="moncompte">Mon Compte</a>
          
          <c:if test="${(sessionPersonne.type_Personne) == 'SALARIE'}">
         <li class="nav-item">
            <a class="nav-link js-scroll-trigger" href="/Bibliotheques/admin/accueil">
          <c:out value="Administration"/></a>
          </li>
          </c:if>
          </li>
            <a class="nav-link js-scroll-trigger" href="deconnexion">Se deconnecter</a>
          </li>
        </ul>
      </div>
    </div>
  </nav>