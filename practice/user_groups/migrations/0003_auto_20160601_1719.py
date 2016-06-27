# -*- coding: utf-8 -*-
# Generated by Django 1.9.4 on 2016-06-01 17:19
from __future__ import unicode_literals

from django.db import migrations, models


class Migration(migrations.Migration):

    dependencies = [
        ('user_groups', '0002_auto_20160601_1716'),
    ]

    operations = [
        migrations.AlterField(
            model_name='usergroup',
            name='members',
            field=models.ManyToManyField(blank=True, related_name='members', to='user_groups.UserDetail'),
        ),
    ]
