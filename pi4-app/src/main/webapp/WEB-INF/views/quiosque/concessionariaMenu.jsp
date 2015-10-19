<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="cabecalho.jsp"></jsp:include> 
<div class="row">
                <div class="col-md-12 text-center">
                <h3 class=""><strong>Menu Principal</strong></h3>
            </div>
            <div class="col-md-12 text-center">
            <form action="" method="post" id="form">
            <div>
            <select name="idSelecionado" id="idSelecionado" class="form-control">
            	<option value="0">-</option>
            	<option value="1">1</option>
            	<option value="2">2</option>
            	<option value="3">3</option>
            </select>
            
            </div>
                <div class="">
                    <input type="submit" class="btn btn-inverse" id="" value="Pedidos"/>
                </div>              

            </div>
            </form>
            
            <script>
            $(document).ready(function(){ 		
            		$("#idSelecionado").change(function(){
            			var id = $(this).val();
            			$("#form").attr("action","/pi4-app/quiosque/concessionaria/listarPedidos/"+id);
            		});
            	});
            </script>
 <jsp:include page="rodape.jsp"></jsp:include>  