package se.edvard.houserobbery;

import se.edvard.houserobbery.model.Resident;

//interface som gör items användbara
public interface ItemUse {
    ItemUse use(Resident r);
}
