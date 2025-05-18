package mx.unam.aragon.ico.te.musicamvc.controladores;

import org.springframework.ui.Model;
import mx.unam.aragon.ico.te.musicamvc.modelos.Artista;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/tienda")
public class MusicaController {
    @GetMapping("/home/")
    public String home(){
        return "home";
    }
    @GetMapping("/artista/")
    public String artista(Model model) {
        Artista artista = new Artista("Freddie Mercury",1, "Rock",25, "Algo","https://www.experimenta.es/wp-content/uploads/2018/03/freddie-mercury-el-disenador-grafico.jpg");
        model.addAttribute("artista", artista);
        return "artista";
    }

}
