package twinsFood.CanaryFoodAPI.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import twinsFood.CanaryFoodAPI.interfaces.IRoleService;
import twinsFood.CanaryFoodAPI.models.Role;
import twinsFood.CanaryFoodAPI.repositories.RoleRepository;

@Service
public class RoleService implements IRoleService {

    @Autowired
    private RoleRepository rr;

    @Override
    public void createRole(Role role) {
        rr.save(role);
    }
}
