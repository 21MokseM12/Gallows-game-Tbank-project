package backend.academy.gallow_game.states;

import backend.academy.gallow_game.exceptions.GallowsStateNotFoundException;
import backend.academy.gallow_game.utils.GameFilesManager;
import java.util.List;

public class GallowsStateManager {

    private List<String> currentGallowsState;

    public void setState(int countFails) throws GallowsStateNotFoundException {
        this.currentGallowsState = GameFilesManager.getGallowsStates(countFails);
    }

    public  List<String> getCurrentState() {return this.currentGallowsState;}
}
