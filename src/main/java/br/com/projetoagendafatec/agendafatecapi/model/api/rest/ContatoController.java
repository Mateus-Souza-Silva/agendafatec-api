package br.com.projetoagendafatec.agendafatecapi.model.api.rest;

import br.com.projetoagendafatec.agendafatecapi.model.entity.Contato;
import br.com.projetoagendafatec.agendafatecapi.model.repository.ContatoRepository;
import lombok.RequiredArgsConstructor;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Part;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/contatos")
@RequiredArgsConstructor
@CrossOrigin("*")
public class ContatoController {

    private final ContatoRepository repository;

//    usado para salvar um objeto e sera usado o post para salvar
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Contato save(@RequestBody Contato contato){
        return repository.save(contato);
    }

    //    usado para listar um objeto
    @GetMapping
    public List<Contato> List(){
        return repository.findAll();
    }

    //    usado para apagar um objeto
    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Integer id){
        repository.deleteById(id);
    }


    @PatchMapping("{id}")
    public void favorite(@PathVariable Integer id){
        Optional<Contato> contato = repository.findById(id);
        contato.ifPresent( c -> {
            boolean favorito = c.getFavorito() == Boolean.TRUE;
            c.setFavorito(!favorito);
            repository.save(c);
        });
    }

    @PutMapping("{id}/foto")
    public byte[] addPhoto(@PathVariable Integer id, @RequestParam("foto") Part arquivo){
        Optional<Contato> contato = repository.findById(id);
        return contato.map(c -> {
            try {
                InputStream inputStream = arquivo.getInputStream();
                byte[] bytes = new byte[(int) arquivo.getSize()];
                IOUtils.readFully(inputStream, bytes);
                c.setFoto(bytes);
                repository.save(c);
                inputStream.close();
                return bytes;
            }catch (IOException ex){
                return null;
            }
        }).orElse(null);
    }
}

