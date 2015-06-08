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
import br.senac.viewmodel.KitAcessorioViewModel;
import java.util.ArrayList;
import java.util.List;

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
    public String abrirLista() {
        return "kit/listar";
    }

    @RequestMapping("/kit/efetivarCadastro")
    public String cadastrar(Model model, KitAcessorio kitAcessorio, KitAcessorioViewModel kitAcessorioViewModel) {

        String id[] = new String[]{
            kitAcessorioViewModel.getId1(),
            kitAcessorioViewModel.getId2(),
            kitAcessorioViewModel.getId3(),
            kitAcessorioViewModel.getId4(),
            kitAcessorioViewModel.getId5()
        };

        List<Acessorio> lista = new ArrayList<Acessorio>();

        for (int i = 0; i < id.length; i++) {
            
            if (id[i] != "0"
                    && id[i] != ""
                    && !lista.contains((Acessorio) acessorioService.getAcessorio(Integer.valueOf(id[i])))) {
                lista.add(acessorioService.getAcessorio(Integer.valueOf(id[i])));
            }
        }
        kitAcessorio.setItensDoKit(lista);
        kitService.cadastrar(kitAcessorio);
        model.addAttribute("kits", kitService.getLista());
        return "kit/formulario";
    }

}
