package com.ankur.urlshortener.redirect.resource;

import com.ankur.urlshortener.common.model.DataStoreId;
import com.ankur.urlshortener.common.model.OriginalUrl;
import com.ankur.urlshortener.shortener.resource.RedirectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;

@Controller
public class RedirectResource {

    private final RedirectService redirectService;

    @Autowired
    public RedirectResource(final RedirectService redirectService) {
        this.redirectService = redirectService;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    void shortenUrl(@PathVariable String id,
                    HttpServletResponse response) throws IOException {
        DataStoreId dataStoreId = DataStoreId.of(id);
        Optional<OriginalUrl> originalUrl = redirectService.getOriginalUrl(dataStoreId);
        if (originalUrl.isPresent()) {
            response.sendRedirect(originalUrl.get().getValue());
        } else {
            response.sendRedirect("/");
        }
    }
}
