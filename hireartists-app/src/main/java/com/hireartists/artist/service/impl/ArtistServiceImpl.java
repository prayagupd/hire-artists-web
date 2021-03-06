package com.hireartists.artist.service.impl;

import com.hireartists.artist.repository.ArtistRepository;
import com.hireartists.client.model.ArtistModel;
import com.hireartists.client.model.SignupModel;
import com.hireartists.domain.Artist;
import com.hireartists.artist.service.ArtistService;
import com.hireartists.domain.User;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by prayagupd
 * on 7/12/15.
 */

@Service
public class ArtistServiceImpl implements ArtistService{

    @Autowired
    ArtistRepository artistRepository;

    public ArtistServiceImpl(){

    }

    @Override
    public Artist save(SignupModel signupModel) {
        Artist artist = new Artist();
        artist.setDisplayName(signupModel.getDisplayName());

        User user = new User();
        user.setUserName(signupModel.getUsername());
        user.setPassword(signupModel.getPassword());
        user.setAuthority("ROLE_ARTIST");
        artist.setUser(user);

        return artistRepository.save(artist);
    }

    @Override
    public Artist getProfile(String username) {
        return artistRepository.getProfile(username);
    }

	@Override
	public List<Artist> findAll() {
		
		return artistRepository.findAll();
	}
}
