package org.progmatic.java.backend.SpringMatchesNIM.module;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Referee {

    public Referee(@Autowired Menu menu) {
        menu.setup();
    }


}
