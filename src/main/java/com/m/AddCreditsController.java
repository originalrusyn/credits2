package com.m;

import com.google.appengine.api.datastore.QueryResultIterator;
import com.googlecode.objectify.ObjectifyService;
import com.googlecode.objectify.cmd.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AddCreditsController {

    Logger logger = LoggerFactory.getLogger(getClass());

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public void ggg() throws Exception {
        logger.debug("ggggggggggg {}", "aaaa");

        Account account = new Account("666", 999, "bb");
        Account account2 = new Account("777", 666, "aaa");

        ObjectifyService.ofy().save().entities(account, account2).now();

        Query<Account> accountQuery = ObjectifyService.ofy().load().type(Account.class).limit(2);

        QueryResultIterator<Account> iterator = accountQuery.iterator();

        for (Account account1 : accountQuery) {

        }


        logger.info(accountQuery.list().toString());
        logger.info(iterator.getCursor().toWebSafeString());

        Account account3 = new Account("888", 333, "fff");

        ObjectifyService.ofy().save().entities(account3).now();
    }

}
