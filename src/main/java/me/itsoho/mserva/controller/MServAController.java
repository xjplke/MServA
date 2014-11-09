package me.itsoho.mserva.controller;

import java.util.Date;

import me.itsoho.mserva.model.ModelA;
import me.itsoho.mserva.repo.ModelARepo;
import me.itsoho.rbac.domain.Manager;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@EnableTransactionManagement
@RestController
@EnableAutoConfiguration
@RequestMapping("/modela")
@Transactional
public class MServAController {
	@Autowired
	private ModelARepo repo;
	
	@RequiresPermissions("modela:edit")
	@RequestMapping(method=RequestMethod.POST)
	public ModelA add(@RequestBody ModelA a){
		return repo.save(a);
	}
	
	@RequiresPermissions("modela:view")
	@RequestMapping(value="/{id}",method=RequestMethod.GET)
	public ModelA get(@PathVariable("id") Long id) throws Exception {
		ModelA a = repo.findOne(id);
		if(null==a){
			throw new Exception("id for "+id+" not found!");
		}
		return a;
	}
	
	@RequiresPermissions("modela:view")
	@RequestMapping(method=RequestMethod.GET)
	public Page<ModelA> get(@RequestParam("page")int page,
					@RequestParam("size") int size){
		Pageable pageable = new PageRequest(page, size, Direction.DESC, "id");
		return repo.findAll(pageable);
	}
}
