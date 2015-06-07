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
import org.springframework.web.bind.annotation.RequestMapping;

import viewmodel.KitAcessorioViewModel;

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
    public String abrirForm(Model model){
    	model.addAttribute("acessorios", acessorioService.getLista());
        return "kit/formulario";
    }
    
    @RequestMapping ("/kit/listar")
    public String abrirLista(){
        return "kit/listar";
    }
    
    @RequestMapping("/kit/efetivarCadastro")
    public String cadastrar(Model model, KitAcessorio kitAcessorio, KitAcessorioViewModel kitAcessorioViewModel){
    	
    	Integer id [] = {
    			kitAcessorioViewModel.getId1(),
    			kitAcessorioViewModel.getId2(),
    			kitAcessorioViewModel.getId3(),
    			kitAcessorioViewModel.getId4(),
    			kitAcessorioViewModel.getId5()
    	};
    	
    	for (int i = 0 ; i<id.length;i++){
    		if (!kitAcessorio.getItensDoKit().contains((Acessorio)acessorioService.getAcessorio(id[i])) ||
    				id[i]!=0)
    		{        		
        		kitAcessorio.getItensDoKit().add(acessorioService.getAcessorio(id[i]));
        	}
    	}
    	
    	kitService.cadastrar(kitAcessorio);
    	model.addAttribute("kits",kitService.getLista());
    	return "kit/listar";
    }    
        
}
