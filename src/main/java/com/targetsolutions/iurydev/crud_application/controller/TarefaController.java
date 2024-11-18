package com.targetsolutions.iurydev.crud_application.controller;

import com.targetsolutions.iurydev.crud_application.model.Tarefa;
import com.targetsolutions.iurydev.crud_application.repository.TarefaRepository;
import com.targetsolutions.iurydev.crud_application.services.TarefaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDate;
import java.util.Optional;

@Controller
@RequestMapping("api/tarefas")
public class TarefaController {

    @Autowired
    private TarefaRepository tarefaRepository;

    @Autowired
    private TarefaService tarefaService;

    @RequestMapping(value = "/cadastro", method = RequestMethod.GET)
    public String form() {
        return "listarTarefas";
    }

    @RequestMapping(value = "/cadastrarTarefa", method = RequestMethod.POST)
    public String cadastrarTarefa(@ModelAttribute Tarefa tarefa, RedirectAttributes redirectAttributes) {
        tarefaRepository.save(tarefa);
        redirectAttributes.addFlashAttribute("successMessage", "Tarefa cadastrada com sucesso!");
        return "redirect:/listarTarefas";
    }

    @RequestMapping(value = "/buscarTarefa", method = RequestMethod.GET)
    public String buscarTarefaPorId(@RequestParam("id") Long id, Model model, RedirectAttributes redirectAttributes) {
        Optional<Tarefa> tarefaOptional = tarefaRepository.findById(id);

        if (tarefaOptional.isPresent()) {
            model.addAttribute("tarefaEncontrada", tarefaOptional.get());
            model.addAttribute("successMessage", "Tarefa encontrada com sucesso!");
            return "resultadoBusca";
        } else {
            redirectAttributes.addFlashAttribute("message", "Tarefa não encontrada!");
            return "redirect:/listarTarefas";
        }
    }

    @RequestMapping("/listarTarefas")
    public String listarTarefas(Model model) {
        Iterable<Tarefa> tarefas = tarefaRepository.findAll();
        model.addAttribute("tarefas", tarefas);
        return "listarTarefas";
    }

    @RequestMapping(value = "/editar/{id}", method = RequestMethod.GET)
    public String editarTarefa(@PathVariable("id") Long id, Model model) {
        Tarefa tarefa = tarefaRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Tarefa inválida: " + id));
        model.addAttribute("tarefa", tarefa);
        return "editarTarefa";
    }

    @RequestMapping(value = "/editar/{id}", method = RequestMethod.POST)
    public String atualizarTarefa(@PathVariable("id") Long id,
                                  @RequestParam("datacriacao") String datacriacao,
                                  @RequestParam("titulo") String titulo,
                                  @RequestParam("descricao") String descricao,
                                  @RequestParam("status") String status,
                                  RedirectAttributes redirectAttributes) {
        Tarefa tarefa = tarefaRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Tarefa inválida: " + id));

        tarefa.setDatacriacao(LocalDate.parse(datacriacao));
        tarefa.setTitulo(titulo);
        tarefa.setDescricao(descricao);
        tarefa.setStatus(status);
        tarefaRepository.save(tarefa);

        redirectAttributes.addFlashAttribute("successMessage", "Tarefa alterada com sucesso!");

        return "redirect:/listarTarefas";
    }


    @GetMapping("/deletar/{id}")
    public String deletarTarefa(@PathVariable Long id, RedirectAttributes redirectAttributes) {
        try {
            tarefaService.deletarTarefa(id);
            redirectAttributes.addFlashAttribute("message", "Tarefa excluída com sucesso!");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("message", "Erro ao excluir tarefa.");
        }
        return "redirect:/listarTarefas";
    }
}