package mx.unam.aragon.ico.te.musicamvc.controladores;

import org.slf4j.LoggerFactory;
import org.springframework.ui.Model;
import mx.unam.aragon.ico.te.musicamvc.modelos.Artista;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/tienda")
public class MusicaController {
    @GetMapping("/home/")
    public String home(){
        return "home";
    }
    @GetMapping("/artista/")
    public String artista(Model model) {
        Artista artista = new Artista("Freddie Mercury",1, "Rock",25, "Algo","https://upload.wikimedia.org/wikipedia/commons/thumb/9/96/Freddie_Mercury_%281977_Press_Kit_Photo%29.jpg/330px-Freddie_Mercury_%281977_Press_Kit_Photo%29.jpg");
        model.addAttribute("artista", artista);
        return "artista";
    }
    @GetMapping("/nuevo")
    public String nuevo(Model model){
        model.addAttribute("artista", new Artista("Abel", 0,"Rock",30,"Fin de semana","http:algo"));
        return "formArtista";
    }

    @PostMapping("/guardar")
    public String guardar(
            /*Recupera los campos. Spring mapea el formulario.*/
            @ModelAttribute Artista artista
    ){
        LoggerFactory.getLogger(getClass()).info("Guardando artista" + artista);  /* Bitacora del sistema. Para ver donde pueden haber problemas y resolverlo*/
        // mandarlo a BD (save)
        return "redirect:/tienda/nuevo?exito";
    }

}
