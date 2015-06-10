<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>


<jsp:include page="../cabecalho.jsp"></jsp:include> 
<div class="jumbotron">
            <div class="row">
                <div class="col-md-12 text-center"">
                    <h3 class=""><strong>Relatórios</strong></h3>
                </div>
                <div class="col-md-12 text-center">
                    <div class="">
                        <a href=""><input type="button" class="btn btn-inverse" id="relatorio1" value="Veículos mais consultados por idade"/></a>
                    </div>
                    <div class="">
                        <a href=""><input type="button" class="btn btn-inverse" id="relatorio2" value="Veículos mais consultados por Sexo"/></a>
                    </div>
                    <div class="">
                        <a href=""><input type="button" class="btn btn-inverse" id="relatorio3" value="Veículos mais consultados por região"/></a>
                    </div>
                    <div class="">
                        <a href=""><input type="button" class="btn btn-inverse" id="relatorio4" value="Concessionárias que mais venderam"/></a>
                    </div>
                    <div class="">
                        <a href=""><input type="button" class="btn btn-inverse" id="relatorio5" value="Veículos mais vendidos"/></a>
                    </div>
                </div>
            </div>

        </div>

<jsp:include page="../rodape.jsp"></jsp:include>  