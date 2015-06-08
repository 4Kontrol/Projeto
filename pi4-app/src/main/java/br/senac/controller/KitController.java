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
    public String cadastrar(Model model, KitAcessorio kitAcessorio, KitAcessorioViewModel kitAcessorioViewModel) {

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
		
		
		//session.setAttribute("kitSessao", kitAcessorio);
		model.addAttribute("kit", kitAcessorio);
		
		return "kit/formulario";
	
	}

}
