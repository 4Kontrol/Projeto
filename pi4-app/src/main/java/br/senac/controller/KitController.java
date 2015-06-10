/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.controller;

import br.senac.model.entidades.Acessorio;
import br.senac.model.entidades.KitAcessorio;
import br.senac.service.AcessorioService;
import br.senac.service.KitService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import br.senac.viewmodel.KitAcessorioViewModel;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

;

/**
 *
 * @author Geovan
 */
@Controller
public class KitController {

    @Autowired
    private KitService kitService;
    @Autowired
    private AcessorioService acessorioService;

    @RequestMapping("/kit/abrirFormulario")
    public String abrirForm(Model model) {
        model.addAttribute("acessorios", acessorioService.getLista());
        return "kit/formulario";
    }

    @RequestMapping("/kit/listar")
    public String abrirLista(Model model) {
    	model.addAttribute("kits",kitService.getLista());
        return "kit/listar";
    }

    @RequestMapping("/kit/efetivarCadastro")
    public String cadastrar(Model model,KitAcessorio kitAcessorio, KitAcessorioViewModel kitAcessorioViewModel) {

        Integer id[] = new Integer[]{
            kitAcessorioViewModel.getId1(),
            kitAcessorioViewModel.getId2(),
            kitAcessorioViewModel.getId3(),
            kitAcessorioViewModel.getId4(),
            kitAcessorioViewModel.getId5()
        };

        List<Acessorio> lista = new ArrayList<Acessorio>();

        for (int i = 0; i < id.length; i++) {
            
            if (id[i] != 0
                    && id[i] != null
                    && !lista.contains((Acessorio) acessorioService.getAcessorio(id[i]))) {
                lista.add(acessorioService.getAcessorio(id[i]));
            }
        }
        kitAcessorio.setItensDoKit(lista);
        kitService.cadastrar(kitAcessorio);
        model.addAttribute("kits", kitService.getLista());
        return "kit/listar";
    }
       
    
    @RequestMapping("/kit/abrirFormulario/{id}")
	public String editar(Model model, @PathVariable("id") Integer id, HttpSession session){
		
		KitAcessorio kitAcessorio = kitService.getKitAcessorio(id);
		KitAcessorioViewModel kitAcessorioViewModel =  new KitAcessorioViewModel();
		kitAcessorioViewModel.setId1(verificaNull(kitAcessorio.getItensDoKit(),0));
		kitAcessorioViewModel.setId2(verificaNull(kitAcessorio.getItensDoKit(),1));
		kitAcessorioViewModel.setId3(verificaNull(kitAcessorio.getItensDoKit(),2));
		kitAcessorioViewModel.setId4(verificaNull(kitAcessorio.getItensDoKit(),3));
		kitAcessorioViewModel.setId5(verificaNull(kitAcessorio.getItensDoKit(),4));
		
		
		//session.setAttribute("kitSessao", kitAcessorio);
		model.addAttribute("acessorios", acessorioService.getLista());
		model.addAttribute("kitAcessorioViewModel",kitAcessorioViewModel);
		model.addAttribute("kit", kitAcessorio);		
		return "kit/formulario";	
	}
    
    private static Integer verificaNull(List<Acessorio> acessorio,Integer i){
    	try {
    		return acessorio.get(i).getId();
    	}catch(Exception e){
    		return 0 ;
    	}
    }
    
    @RequestMapping("/kit/efetivarEdicao")
    public String confirmarEdicao (Model model,KitAcessorio kitAcessorio, KitAcessorioViewModel kitAcessorioViewModel){
    	Integer id[] = new Integer[]{
                kitAcessorioViewModel.getId1(),
                kitAcessorioViewModel.getId2(),
                kitAcessorioViewModel.getId3(),
                kitAcessorioViewModel.getId4(),
                kitAcessorioViewModel.getId5()
            };

            List<Acessorio> lista = new ArrayList<Acessorio>();

            for (int i = 0; i < id.length; i++) {                
                if (id[i] != 0
                        && id[i] != null
                        && !lista.contains((Acessorio) acessorioService.getAcessorio(id[i]))) {
                    lista.add(acessorioService.getAcessorio(id[i]));
                }
            }
            kitAcessorio.setItensDoKit(lista);
            kitService.editar(kitAcessorio);
            model.addAttribute("kits", kitService.getLista());
            return "kit/listar";
                
    	
    }

}
