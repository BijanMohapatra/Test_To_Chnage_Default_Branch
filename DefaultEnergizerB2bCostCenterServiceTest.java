/**
 *
 */
package com.energizer.services.product.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.when;

import de.hybris.bootstrap.annotations.UnitTest;
import de.hybris.platform.b2b.model.B2BCostCenterModel;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

import com.energizer.services.product.dao.EnergizerB2bCostCenterDao;


/**
 * @author M1075043
 *
 */

@UnitTest
@RunWith(MockitoJUnitRunner.class)
public class DefaultEnergizerB2bCostCenterServiceTest
{

	@InjectMocks
	DefaultEnergizerB2bCostCenterService defaultEnergizerB2bCostCenterServiceTest = new DefaultEnergizerB2bCostCenterService();
	@Mock
	EnergizerB2bCostCenterDao energizerB2bCostCenterDao;

	@Before
	public void setUp()
	{
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void findB2BCostCenterListTest()
	{
		final B2BCostCenterModel b2BCostCenterModel = Mockito.mock(B2BCostCenterModel.class);
		final List<B2BCostCenterModel> b2BCostCenterModelList = new ArrayList<B2BCostCenterModel>();
		b2BCostCenterModelList.add(b2BCostCenterModel);
		final String code = "TestCode";
		when(energizerB2bCostCenterDao.findB2BCostCenterList(code)).thenReturn(b2BCostCenterModelList);
		assertNotNull(defaultEnergizerB2bCostCenterServiceTest.findB2BCostCenterList(code));
		assertEquals(defaultEnergizerB2bCostCenterServiceTest.findB2BCostCenterList(code), b2BCostCenterModelList);
	}


	@Test
	public void findB2BCostCenterListNullTest()
	{
		final B2BCostCenterModel b2BCostCenterModel = Mockito.mock(B2BCostCenterModel.class);
		final List<B2BCostCenterModel> b2BCostCenterModelList = new ArrayList<B2BCostCenterModel>();
		b2BCostCenterModelList.add(b2BCostCenterModel);
		final String code = null;
		when(energizerB2bCostCenterDao.findB2BCostCenterList(code)).thenReturn(null);
		assertNull(defaultEnergizerB2bCostCenterServiceTest.findB2BCostCenterList(code));
	}
}
