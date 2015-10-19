<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>


<jsp:include page="../cabecalho.jsp"></jsp:include> 
<div class="jumbotron">
            <div class="row">
              <div class="col-md-12">
                  <h3><strong>Veículos mais consultados por faixa de idade</strong></h3>
              </div>
                <div class="col-md-3"></div>
                <div class="col-md-6">
                    <table class="table table-bordered">
                        <tr><th>Faixa de idade</th><th>Veículo</th></tr>
                        <tr><td>18 a 30 anos</td><td></td></tr>
                        <tr><td>31 a 50 anos</td><td></td></tr>
                        <tr><td>Idade maior que 50 anos</td><td></td></tr>
                    </table>
                </div>
                <div class="col-md-12">
                    <a href=""><input class="btn btn-success" value="Voltar ao menu relatórios" type="button"/></a>
                </div>
            </div>
        </div>

<jsp:include page="../rodape.jsp"></jsp:include>  