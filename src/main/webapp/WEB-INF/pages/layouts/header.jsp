<%-- 
    Document   : header
    Created on : 27/03/2017, 03:05 PM
    Author     : ES - Erick SUlbaran
--%>
	<!-- Preloader
	============================================= -->
    <%@ include file="../common/taglibs.jsp"%>
        <!-- Header
	============================================= -->
    
                        
        <nav class="menu">
            <div class="con-logo">
              <img src="<c:url value="/resources/images/limed.png" />" width="70" height="50">
            </div>
            <ul>
                <li class="dropdown"><p class="dropdown-toggle navbtn" data-toggle="dropdown">Citas<span id="citas-caret" class="glyph-icon flaticon-down-arrow"></span></p>
                    <ul class="dropdown-menu">
                        <li><a id="citasVerificar-option" class="navdrop">Verificar</a></li>
                        <li><a id="citasAvanzar-option" class="navdrop">Avanzar</a></li>
                    </ul>
                </li>
                <li><button id="auditoria-menu" type="button"><p>Auditor&iacute;a</p></button></li>
                <li class="dropdown"><p class="dropdown-toggle navbtn" data-toggle="dropdown">Excepciones<span id="excepciones-caret" class="glyph-icon flaticon-down-arrow"></span></p>
                    <ul class="dropdown-menu">
                        <li><a id="excepcionesSolicitar-option" class="navdrop">Solicitar</a></li>
                        <li><a id="excepcionesConsultar-option" class="navdrop">Consultar</a></li>
                    </ul>
                </li>
                <li><button id="reprogramar-menu" type="button"><p>Reprogramar</p></button></li>
                <li><button id="reevaluacion-menu" type="button"><p>Reevaluaci&oacute;n</p></button></li>
            </ul>
        </nav>
    