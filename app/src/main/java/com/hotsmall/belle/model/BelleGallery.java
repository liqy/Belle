package com.hotsmall.belle.model;

import com.hotsmall.belle.service.BelleService;

/**
 * Created by liqy on 16/1/17.
 */
public class BelleGallery {

    /**
     * gallery : 10
     * id : 187
     * src : /ext/150714/832903f1079ad2a74867e5cbd9dcf1a2.jpg
     */

    private int gallery;
    private int id;
    private String src;

    public void setGallery(int gallery) {
        this.gallery = gallery;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setSrc(String src) {
        this.src = src;
    }

    public int getGallery() {
        return gallery;
    }

    public int getId() {
        return id;
    }

    public String getSrc() {
        return BelleService.IMAGE_URL +src;
    }
}
